cd src/main/java/org/parser
rm *.java
java -jar ../../../../../libs/antlr.jar -visitor Stub.g4
sed -i '1s/^/package org.parser;\/\//' *.java
cd ../../../../../
