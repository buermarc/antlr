FROM archlinux
MAINTAINER buermarc@googlemail.com

RUN pacman -Syu --noconfirm
RUN pacman -S --noconfirm llvm clang gradle jre8-openjdk-headless jdk8-openjdk git
RUN mkdir /repos/
RUN git clone https://github.com/buermarc/antlr /repos/antlr
RUN /bin/bash -c 'cd /repos/antlr/parser; sh doit; gradle build'
RUN /bin/bash -c 'cd /repos/antlr/compiler; gradle build'
RUN cp /repos/antlr/compiler/build/libs/compiler.jar /usr/local/lib/compiler.jar
RUN cp /repos/antlr/stubc /usr/local/bin/stubc
RUN chmod 700 /usr/local/bin/stubc
CMD ["/bin/bash", "-c", "sleep infinity"]
