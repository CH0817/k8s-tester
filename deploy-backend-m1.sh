BASE_PROJECT_HOME="$HOME/projects/k8s-tester"
PROJECT_HOME="$BASE_PROJECT_HOME/backend"
PROFILE="k8s"
LOCAL_IMAGE="k8s-backend-m1:v1"
REMOTE_IMAGE="chenhang0817/k8s-backend-m1:v1"
DEPLOY_FILE="backend-deployment.yaml"

cd "$PROJECT_HOME" || exit

# 編譯打包
mvn clean package -P$PROFILE

# 刪除 K8S 布署
cd "$BASE_PROJECT_HOME" || exit
kubectl delete -f "$DEPLOY_FILE"

# 暫停3秒
sleep 3s

# 刪除 local image
docker rmi $LOCAL_IMAGE
docker rmi $REMOTE_IMAGE

# 產生 backend image
cd "$PROJECT_HOME" || exit
docker build -t $LOCAL_IMAGE .

# image 上 tag
docker tag $LOCAL_IMAGE $REMOTE_IMAGE

# image 推到 docker server
# docker push $REMOTE_IMAGE

# 佈署到 K8S
cd "$BASE_PROJECT_HOME" || exit
kubectl apply -f $DEPLOY_FILE