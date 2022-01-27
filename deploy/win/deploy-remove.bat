@echo off

@set K8S_DEPLOY_HOME=%PROJECT_HOME%/k8s-tester/deploy

call kubectl delete -f %K8S_DEPLOY_HOME%/k8s/backend-deployment.yaml
call kubectl delete -f %K8S_DEPLOY_HOME%/k8s/frontend-deployment.yaml
call kubectl delete -f %K8S_DEPLOY_HOME%/k8s/gateway-deployment.yaml
call kubectl delete -f %K8S_DEPLOY_HOME%/k8s/api-deployment.yaml

@REM 暫停3秒
timeout 3 > NUL

@REM 刪除 image
call docker rmi k8s-frontend:v1
call docker rmi chenhang0817/k8s-frontend:v1
call docker rmi k8s-backend:v1
call docker rmi chenhang0817/k8s-backend:v1
call docker rmi k8s-gateway:v1
call docker rmi chenhang0817/k8s-gateway:v1
call docker rmi k8s-api:v1
call docker rmi chenhang0817/k8s-api:v1