@echo off

@set K8S_DEPLOY_HOME=%PROJECT_HOME%/k8s-tester/deploy

call kubectl delete -f %K8S_DEPLOY_HOME%/ingress-nginx.yaml
call kubectl delete -f %K8S_DEPLOY_HOME%/win/backend-deployment.yaml
call kubectl delete -f %K8S_DEPLOY_HOME%/win/frontend-deployment.yaml