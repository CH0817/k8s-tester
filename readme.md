# Kubernetes 練習

- spring boot version: 2.4.6
- spring cloud version: 2020.0.3

## frontend

- port: 8080
- context-path: /frontend

## backend

- port: 8081
- context-path: /backend

## harbor

vm url: http://192.168.56.22:85

### front

tag:

```shell
docker tag k8s-frontend:0.0.1-SNAPSHOT 192.168.56.22:85/k8s-tester/k8s-frontend:v1
```

push:
```shell
docker push 192.168.56.22:85/k8s-tester/k8s-frontend:v1
```

pull
```shell
docker pull 192.168.56.22:85/k8s-tester/k8s-frontend:v1
```

### backend

tag:

```shell
docker tag k8s-backend:0.0.1-SNAPSHOT 192.168.56.22:85/k8s-tester/k8s-backend:v1
```

push:
```shell
docker push 192.168.56.22:85/k8s-tester/k8s-backend:v1
```

pull
```shell
docker pull 192.168.56.22:85/k8s-tester/k8s-backend:v1
```

## kubernetes

- master vm url: http://192.168.56.20
- node-1 vm url: http://192.168.56.21
- node-2 vm url: http://192.168.56.22