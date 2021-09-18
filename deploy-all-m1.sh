PROJECT_HOME="$HOME/projects/k8s-tester"

cd "$PROJECT_HOME" || exit

# 刪除 K8S Ingress
kubectl delete -f ingress-nginx.yaml

./deploy-backend-m1.sh
./deploy-frontend-m1.sh

# 布署 K8S Ingress
kubectl apply -f ./ingress-nginx.yaml