@echo off

call kubectl delete -f ingress-nginx.yaml
call kubectl delete -f backend-deployment.yaml
call kubectl delete -f frontend-deployment.yaml