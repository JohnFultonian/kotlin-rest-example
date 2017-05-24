BASE_DOCKER_IMAGE=gradle
docker run \
  -it \
  -v $(pwd):/data \
  -v $HOME/.m2:/home/gradle/.m2 \
  -v $HOME/.gradle:/home/gradle/.gradle \
  -w /data \
  $BASE_DOCKER_IMAGE gradle $@
