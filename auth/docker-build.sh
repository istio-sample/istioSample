#!/usr/bin/env bash
# sh파일 경로로 이동 (cd) 후 실행 필요 - front 까지 같이 build/push
mvn clean package -e -U -Dmaven.test.skip=true

docker build . --tag mura2393/istio-auth
docker push mura2393/istio-auth

cd ../front/

mvn clean package -e -U -Dmaven.test.skip=true

docker build . --tag mura2393/istio-front
docker push mura2393/istio-front