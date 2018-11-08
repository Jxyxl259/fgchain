# Image build procedure
FROM centos:latest

MAINTAINER Tommie.J <jiangbug@outlook.com>
ENV project_env dev
RUN yum install -y vim net-tools

EXPOSE 80 80
