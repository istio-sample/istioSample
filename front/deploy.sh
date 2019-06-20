#!/usr/bin/env bash

# kubectl label namespace default istio-injection=enabled 네임스페이스에 적용하면, 아래 istioctl을 생략할 수 있음
kubectl apply -f <(istioctl kube-inject -f k8s/front.yml)