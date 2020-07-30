FROM centos
MAINTAINER buermarc@googlemail.com

RUN yum -y update
RUN yum -y install git java-1.8.0-openjdk-headless java-1.8.0-openjdk-devel llvm-toolset
RUN mkdir /repos/
RUN /bin/bash -c 'echo i'
RUN git clone https://github.com/buermarc/antlr /repos/antlr
RUN /bin/bash /repos/antlr/gradle_centos.sh
RUN source /etc/profile.d/gradle.sh
RUN /bin/bash -c 'source /etc/profile.d/gradle.sh; cd /repos/antlr/parser; sh doit; gradle build'
RUN /bin/bash -c 'source /etc/profile.d/gradle.sh; cd /repos/antlr/compiler; gradle build'
RUN cp /repos/antlr/compiler/build/libs/compiler.jar /usr/local/lib/compiler.jar
RUN cp /repos/antlr/stubc /usr/local/bin/stubc
RUN chmod 700 /usr/local/bin/stubc
CMD ["/bin/bash", "-c", "sleep infinity"]
