FROM archlinux
MAINTAINER buermarc@googlemail.com

RUN pacman -Syu --noconfirm
RUN pacman -S --noconfirm llvm clang gradle jre8-openjdk-headless jdk8-openjdk git
RUN mkdir /repos/
RUN git clone https://github.com/buermarc/sam /repos/sam
RUN /bin/bash -c 'cd /repos/sam; pwd'
CMD ["/bin/bash", "-c", "sleep infinity"]
