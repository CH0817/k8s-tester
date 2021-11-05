K8S_DEPLOY_HOME=$PROJECT_HOME/k8s-tester/deploy/mac

"$K8S_DEPLOY_HOME/deploy-remove.sh"
"$K8S_DEPLOY_HOME/deploy-backend.sh"
"$K8S_DEPLOY_HOME/deploy-frontend.sh"
"$K8S_DEPLOY_HOME/deploy-gateway.sh"