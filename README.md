## Apache Flink 学习笔记

### 1. 什么是Flink

> Apache Flink is a framework and distributed processing engine for stateful computations over *unbounded and bounded* data streams. Flink has been designed to run in *all common cluster environments*, perform computations at *in-memory speed* and at *any scale*.	 
>
> https://flink.apache.org/flink-architecture.html

<kbd style="padding:6px">distributed</kbd>    <kbd style="padding:6px">streams</kbd>    <kbd style="padding:6px">unbounded and bounded</kbd>  

javadoc:   https://ci.apache.org/projects/flink/flink-docs-release-1.8/api/java/

training:   https://training.ververica.com/

### 2. java最简单例子

添加依赖

```xml
<dependency>
    <groupId>org.apache.flink</groupId>
    <artifactId>flink-java</artifactId>
    <version>1.8.0</version>
</dependency>
<dependency>
    <groupId>org.apache.flink</groupId>
    <artifactId>flink-streaming-java_2.11</artifactId>
    <version>1.8.0</version>
</dependency>
<dependency>
    <groupId>org.apache.flink</groupId>
    <artifactId>flink-clients_2.11</artifactId>
    <version>1.8.0</version>
</dependency>
```

Tuple2类的应用例子：

```java
Tuple2<String, Integer> person = new Tuple2<String, Integer>("Fred", 35);
// zero based index!  
String name = person.f0;
Integer age = person.f1;
System.out.println("name == "+name);
System.out.println("age == "+age);
```

Tuple类是一个抽象类，总共有26个实现类(Tuple0~Tuple25)。

### 3. CentOS下安装flink

版本：Apache Flink 1.8.0 with Hadoop 2.4 for Scala 2.11 

下载地址：https://flink.apache.org/downloads.html

运行环境：java 1.8+

下载文件，解压到任意路径。

本地启动：

```bash
## 跳转到指定文件
cd flink-1.8.0/bin
./start-scala-shell.sh local
```

启动成功后，访问默认的8081端口即可。例如：http://withyan.cn:8081/



### 4.下载官网例子

配置maven环境后，下载官网提供的项目。

```bash
curl https://flink.apache.org/q/quickstart.sh | bash
```

