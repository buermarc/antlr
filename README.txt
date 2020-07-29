Bootstraping the project:
    One can build the project in a container. Just use the bootstrap.sh script 
    to build the docker container defined in the Dockerfile. After downloading 
    all dependencies, building the project and installing the builded artifacts,
    one while get shell access in the container. 
    From here one can use 'stubc <my_programm.st>' to execute the compiler. This
    should produce an executable in the same directory named <my_programm>.
    The bootstrap.sh script can used everytime on wants access to the shell. 
    As all commands executed while building the container are cached and 
    therefore will not be executed again.

    Disclamer:
    After exiting the sell the container should be killed automaticaly. To make 
    sure it is not runnig use the 'docker container ls' command.

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

    if you use want to bootstrap the project:
    docker

Structure:
├── antlr
│   ├── compiler    // the compiler
│   ├── grammar     // the Stub.g4 grammarfile for testing purposes
│   ├── parser      // the parser 
│   └── test
├── literatur       // literatur ... surprise 
├── README.txt      // <-- You are here
└── tex             // Latex

