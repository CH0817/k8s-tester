K8S_DEPLOY_HOME=$PROJECT_HOME/k8s-tester/deploy/mac/

kubectl delete -f "$K8S_DEPLOY_HOME/ingress-nginx.yaml"
kubectl delete -f "$K8S_DEPLOY_HOME/backend-deployment.yaml"
kubectl delete -f "$K8S_DEPLOY_HOME/frontend-deployment.yaml"

sleep 3s

docker rmi k8s-frontend-m1:v1
docker rmi chenhang0817/k8s-frontend-m1:v1
docker rmi k8s-backend-m1:v1
docker rmi chenhang0817/k8s-backend-m1:v1