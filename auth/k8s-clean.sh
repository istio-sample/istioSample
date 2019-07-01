#!/usr/bin/env bash
# sh파일 경로로 이동 (cd) 후 실행 필요

kubectl delete -f ../k8s/choi.sw/gateway.yml

kubectl delete -f ../k8s/choi.sw/auth_policy.yml

kubectl delete -f ../k8s/choi.sw/front.yml

kubectl delete -f ../k8s/choi.sw/auth.yml