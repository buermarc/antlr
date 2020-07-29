docker build -t antlr:one .
CONT=$(docker run --rm --detach antlr:one)
docker exec -it $CONT /bin/bash
Dependencies:
    gradle
    clang
    llvm tool set
    java

Structure:
├── antlr
│   ├── compiler    // the compiler
│   ├── grammar     // the Stub.g4 grammarfile for testing purposes
│   ├── parser      // the parser 
│   └── test
├── literatur       // literatur ... surprise 
├── README.txt      // <-- You are here
└── tex             // Latex
