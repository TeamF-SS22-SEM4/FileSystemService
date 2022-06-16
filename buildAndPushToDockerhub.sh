./gradlew build
docker build -f src/main/docker/Dockerfile.jvm -t smighty/filesystem-service .
docker push smighty/filesystem-service:latest