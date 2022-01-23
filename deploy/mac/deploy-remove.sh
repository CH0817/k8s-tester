K8S_DEPLOY_HOME=$PROJECT_HOME/k8s-tester/deploy/k8s/

kubectl delete -f "$K8S_DEPLOY_HOME/api-deployment.yaml"
kubectl delete -f "$K8S_DEPLOY_HOME/backend-deployment.yaml"
kubectl delete -f "$K8S_DEPLOY_HOME/frontend-deployment.yaml"
kubectl delete -f "$K8S_DEPLOY_HOME/gateway-deployment.yaml"

sleep 5

docker rmi k8s-api:v1
docker rmi chenhang0817/k8s-api:v1
docker rmi k8s-frontend:v1
docker rmi chenhang0817/k8s-frontend:v1
docker rmi k8s-backend:v1
docker rmi chenhang0817/k8s-backend:v1
docker rmi k8s-gateway:v1
docker rmi chenhang0817/k8s-gateway:v1