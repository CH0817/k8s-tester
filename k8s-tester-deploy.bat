@echo off

:: 設定變數，注意等號左右不能有空格，否則會被視為字串
@set PROJECT_HOME=D:\Develop\Projects\k8s-tester
@set PROFILE=k8s

::編譯打包
cd "%PROJECT_HOME%"
call mvn clean package -f "pom.xml" -P%PROFILE%

::產生 front image
cd "%PROJECT_HOME%\frontend"
call docker build -t k8s-frontend:v1 .

::產生 backend image
cd "%PROJECT_HOME%\backend"
call docker build -t k8s-backend:v1 .

:: image 上 tag
call docker tag k8s-frontend:v1 chenhang0817/k8s-frontend:v1
call docker tag k8s-backend:v1 chenhang0817/k8s-backend:v1

:: image 推到 docker server
call docker push chenhang0817/k8s-frontend:v1
call docker push chenhang0817/k8s-backend:v1

:: 佈署到 K8S
cd "%PROJECT_HOME%"
call kubectl delete -f ingress-nginx.yaml
call kubectl delete -f frontend-deployment.yaml
call kubectl delete -f backend-deployment.yaml
call kubectl apply -f frontend-deployment.yaml
call kubectl apply -f backend-deployment.yaml
call kubectl apply -f ingress-nginx.yaml