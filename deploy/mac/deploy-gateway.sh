WORK_HOME=$PROJECT_HOME/k8s-tester/gateway
LOCAL_IMAGE=k8s-gateway-m1:v1
REMOTE_IMAGE=chenhang0817/k8s-gateway-m1:v1
K8S_DEPLOY_FILE=$PROJECT_HOME/k8s-tester/deploy/mac/gateway-deployment.yaml
PROFILE=$1

if [ -z "$PROFILE" ]
then
    PROFILE=k8s
fi

mvn clean package -f "$WORK_HOME/pom.xml" -P$PROFILE
docker build -t $LOCAL_IMAGE "$WORK_HOME"
docker tag $LOCAL_IMAGE $REMOTE_IMAGE
kubectl apply -f "$K8S_DEPLOY_FILE"