@echo off

:: 設定變數，注意等號左右不能有空格，否則會被視為字串
@set PROJECT_HOME=D:\Develop\Projects\k8s-tester
@set PROFILE=k8s
@set LOCAL_IMAGE=k8s-backend:v1
@set REMOTE_IMAGE=chenhang0817/k8s-backend:v1
@set DEPLOY_FILE_NAME=backend-deployment.yaml

::編譯打包
cd "%PROJECT_HOME%\backend"
call mvn clean package -f "pom.xml" -P%PROFILE%

::刪除 K8S 布署
cd "%PROJECT_HOME%"
call kubectl delete -f %DEPLOY_FILE_NAME%

::暫停3秒
timeout 3 > NUL

::刪除 image
call docker rmi %LOCAL_IMAGE%
call docker rmi %REMOTE_IMAGE%

::產生 backend image
cd "%PROJECT_HOME%\backend"
call docker build -t %LOCAL_IMAGE% .

:: image 上 tag
call docker tag %LOCAL_IMAGE% %REMOTE_IMAGE%

:: image 推到 docker server
:: call docker push %REMOTE_IMAGE%

:: 佈署到 K8S
cd "%PROJECT_HOME%"
call kubectl apply -f %DEPLOY_FILE_NAME%