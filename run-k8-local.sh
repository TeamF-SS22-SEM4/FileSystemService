eval $(minikube docker-env)

kubectl delete -f ./kubernetes/local/filesystem-microservice-deployment.yml

./gradlew build
docker build -f src/main/docker/Dockerfile.jvm -t team-f-filesystem-microservice-jvm .

kubectl apply -f ./kubernetes/local/filesystem-microservice-deployment.yml