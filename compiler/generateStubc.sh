#!/bin/bash
PATH=$(pwd)

JAR=/build/libs/compiler.jar

printf '#!/bin/bash\n'"java -jar ${PWD}${JAR} "'$@' > stubc
