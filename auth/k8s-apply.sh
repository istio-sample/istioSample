#!/usr/bin/env bash
# sh파일 경로로 이동 (cd) 후 실행 필요
kubectl create ns foo

kubectl apply -f <(istioctl kube-inject -f ../k8s/choi.sw/front.yml) -n foo

kubectl apply -f <(istioctl kube-inject -f ../k8s/choi.sw/auth.yml) -n foo

kubectl apply -f ../k8s/choi.sw/gateway.yml

kubectl apply -f ../k8s/choi.sw/auth_policy.yml