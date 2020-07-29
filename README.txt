docker build -t antlr:one .
CONT=$(docker run --rm --detach antlr:one)
docker exec -it $CONT /bin/bash
