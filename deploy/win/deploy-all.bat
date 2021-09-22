@echo off

@set K8S_DEPLOY_HOME=%PROJECT_HOME%/k8s-tester/deploy

@REM 刪除 K8S Ingress
call kubectl delete -f %K8S_DEPLOY_HOME%/ingress-nginx.yaml

call %K8S_DEPLOY_HOME%/win/deploy-backend.bat
call %K8S_DEPLOY_HOME%/win/deploy-frontend.bat

@REM 布署 K8S Ingress
call kubectl apply -f %K8S_DEPLOY_HOME%/ingress-nginx.yaml