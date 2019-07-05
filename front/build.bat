mvn clean package -e -U -Dmaven.test.skip=true

docker build . --build-arg BGENV=BLUE --tag leel2415/istio-front
docker push leel2415/istio-front

kubectl delete -n msaunit-test1 -f ../k8s/front.yml
kubectl apply -n msaunit-test1 -f ../k8s/front.yml