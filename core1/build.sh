#!/usr/bin/env bash
mvn clean package -e -U -Dmaven.test.skip=true

docker build . --tag leel2415/istio-core1
docker push leel2415/istio-core1



