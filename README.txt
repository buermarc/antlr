Bootstraping the project:

    One can build the project in a container. The bootstrap.sh script 
    will build a docker container defined in the Dockerfile. After downloading 
    all dependencies, building the project and installing the builded artifacts,
    one will get shell access in the container. 
    From here on, one can use 'stubc <my_programm.st>' to execute the compiler. This
    should produce an executable in the same directory as the defined code in <my_programm.st>.
    The executable will be named <my_programm>.
    The bootstrap.sh script can be used everytime one wants access to the shell.
    All commands executed while building the container are cached and 
    therefore will not be executed again.

    Disclamer:
    After exiting the shell the container will be killed automaticaly. To make 
    sure it is stopped runnig you can use the 'docker container ls' command.

    There are two container images, using the CENTOS Container will likely be 
    faster and smaller.

    CENTOS Container:
    docker build -t antlr:one .  0.45s user 0.42s system 0% cpu 4:22.33 total

    REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
    antlr               one                 ------------        ------------        1.37GB
    centos              latest              ------------        ------------        215MB

    Arch Container:
    docker build -t antlr:two .  0.12s user 0.11s system 0% cpu 5:50.85 total

    REPOSITORY          TAG                 IMAGE ID            CREATED              SIZE
    antlr               two                 ------------        ------------         1.86GB
    archlinux           latest              ------------        ------------         415MB



Dependencies:
    gradle
    clang
    llvm tool set
    java
    make
    [docker] // optional
