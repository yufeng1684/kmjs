# Zipkin

从spring boot 2.0开始，官方就不再支持使用自建Zipkin Server的方式进行服务链路追踪，而是直接提供了编译好的 jar 包来给我们使用。可以参考

[Quickstart · OpenZipkin](https://zipkin.io/pages/quickstart.html)

本章中选在java的启动方式

If you have Java 8 or higher installed, the quickest way to get started is to fetch the [latest release](https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec) as a self-contained executable jar:

```shell
java -jar zipkin*.jar
```