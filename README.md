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

