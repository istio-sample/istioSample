#!/usr/bin/env bash
# sh파일 경로로 이동 (cd) 후 실행 필요
kubectl create ns foo

kubectl delete -f ../k8s/choi.sw/front.yml

kubectl delete -f ../k8s/choi.sw/auth.yml

kubectl apply -f <(istioctl kube-inject -f ../k8s/choi.sw/front.yml) -n foo

kubectl apply -f <(istioctl kube-inject -f ../k8s/choi.sw/auth.yml) -n foo