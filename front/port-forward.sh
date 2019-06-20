#!/usr/bin/env bash

kubectl port-forward $(kubectl  get pod -l app=front -o jsonpath='{.items[0].metadata.name}') 8080:8080