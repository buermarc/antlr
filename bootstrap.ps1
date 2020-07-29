docker build -t antlr:one . 
$env:CONT = docker run --rm --detach antlr:one
docker exec -it $env:CONT /bin/bash 
docker kill $env:CONT
