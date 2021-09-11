@echo off

@set PROJECT_HOME=D:\Develop\Projects\k8s-tester

cd "%PROJECT_HOME%"

::刪除 K8S Ingress
call kubectl delete -f ingress-nginx.yaml

call .\deploy-backend.bat
call .\deploy-frontend.bat

:: 布署 K8S Ingress
call kubectl apply -f ingress-nginx.yaml