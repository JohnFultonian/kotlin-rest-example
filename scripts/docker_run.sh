BASE_DOCKER_IMAGE=gradle
PORTS="8080:8080"
docker run \
  -it \
  -p $PORTS \
  -v $(pwd):/data \
  -v $HOME/.m2:/home/gradle/.m2 \
  -v $HOME/.gradle:/home/gradle/.gradle \
  -w /data \
  $BASE_DOCKER_IMAGE gradle $@
