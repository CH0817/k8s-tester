@echo off

@REM 設定變數，注意等號左右不能有空格，否則會被視為字串
@set WORK_HOME=%PROJECT_HOME%/k8s-tester/backend
@set LOCAL_IMAGE=k8s-backend:v1
@set REMOTE_IMAGE=chenhang0817/k8s-backend:v1
@set K8S_DEPLOY_FILE=%PROJECT_HOME%/k8s-tester/deploy/k8s/backend-deployment.yaml
@set PROFILE=%1%

if "%PROFILE%" equ "" (
    @set PROFILE=k8s
)

@REM 編譯打包
call mvn clean package -f %WORK_HOME%/pom.xml -P%PROFILE%

@REM 刪除 K8S 布署
call kubectl delete -f %K8S_DEPLOY_FILE%

@REM 暫停3秒
timeout 3 > NUL

@REM 刪除 image
call docker rmi %LOCAL_IMAGE%
call docker rmi %REMOTE_IMAGE%

@REM 產生 backend image
call docker build -t %LOCAL_IMAGE% %WORK_HOME%

@REM image 上 tag
call docker tag %LOCAL_IMAGE% %REMOTE_IMAGE%

@REM image 推到 docker server
@REM call docker push %REMOTE_IMAGE%

@REM 佈署到 K8S
call kubectl apply -f %K8S_DEPLOY_FILE%