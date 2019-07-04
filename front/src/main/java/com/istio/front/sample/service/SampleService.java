package com.istio.front.sample.service;

import com.istio.front.sample.client.AuthClient;
import com.istio.front.sample.client.CircuitClient;
import com.istio.front.sample.client.SampleClient;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

@Service
@Slf4j
public class SampleService {

    @Autowired
    private SampleClient sampleClient;

    @Autowired
    private AuthClient authClient;

    @Autowired
    private CircuitClient circuitClient;

    public Map ab(){
        return sampleClient.sample();
    }

    public Map authPage(){

        Map resultMap = authClient.authInfo();
        log.debug(resultMap.toString());
        return resultMap;
    }

    public Map login(){

        URL url = null;

        Map resultMap = null;
        try{
            url = new URL("https://raw.githubusercontent.com/istio/istio/release-1.2/security/tools/jwt/samples/key.pem");
        

            InputStream is = url.openConnection().getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buff = new char[512];
            int len = -1;
            
            StringBuilder sb= new StringBuilder();

            while( (len = br.read(buff)) != -1) {
                sb.append( new String(buff, 0, len) );
                //log.debug(new String(buff, 0, len));
            }
            log.debug( sb.toString() );

            JWK jwk = JWK.parseFromPEMEncodedObjects(sb.toString());

            
            log.debug( "getAlgorithm::" + jwk.toJSONString() );

            RSAKey rsajwk = (RSAKey) jwk;

            RSAKey rsaPublicJWK = rsajwk.toPublicJWK();

            //RSAKey rsaPrivateJWK = rsajwk.torsa();

            log.debug( "rsajwk::" + rsajwk.toPublicKey() );
            log.debug( "getKeyID::" + rsajwk.getKeyID() );

            JWSSigner signer = new RSASSASigner(rsajwk);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("alice")
                .issuer("https://c2id.com")
                .expirationTime(new Date(new Date().getTime() + 5 * 1000))
                .build();
            
            SignedJWT signedJWT = new SignedJWT(
                    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("DHFbpoIUqrY8t2zpA2qXfCmr5VO5ZEr4RzHU_-envvQ").build(),
                    claimsSet);
            
            signedJWT.sign(signer);

            String s = signedJWT.serialize();

            log.debug( "token::" + s );

            signedJWT = SignedJWT.parse(s);

            JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);

            log.debug( "verify::" + signedJWT.verify(verifier) );

            //resultMap = authClient.authInfoWithHeader("Bearer " + s);

            resultMap = new HashMap();
            resultMap.put("auth", "Bearer " + s);
            log.debug(resultMap.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }

    public Map circuit01(String circuitType, int failRate, int responseCode){
        Map resultMap = circuitClient.circuit01(circuitType, failRate, responseCode);
        log.info("circuit01");
        return resultMap;
    }
}
