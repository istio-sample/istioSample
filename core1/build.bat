mvn clean package -e -U -Dmaven.test.skip=true

docker build . --build-arg BGENV=BLUE --tag leel2415/istio-core1-blue
docker push leel2415/istio-core1-blue

docker build . --build-arg BGENV=GREEN --tag leel2415/istio-core1-green
docker push leel2415/istio-core1-green


