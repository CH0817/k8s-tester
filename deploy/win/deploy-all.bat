@echo off

@set K8S_DEPLOY_HOME=%PROJECT_HOME%/k8s-tester/deploy

@REM 刪除 K8S deploy
call %K8S_DEPLOY_HOME%/win/deploy-backend.bat
call %K8S_DEPLOY_HOME%/win/deploy-frontend.bat