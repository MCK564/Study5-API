FROM ubuntu:latest
LABEL authors="KHA"

ENTRYPOINT ["top", "-b"]