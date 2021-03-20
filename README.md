# POC: Gradle Jar

It demonstrates how to implement a [Gradle](https://github.com/gradle/gradle) task to generate a [Fat JAR](https://stackoverflow.com/questions/11947037/what-is-an-uber-jar).

The goal is to implement a Java application that prints all arguments informed by the user in a single line using [Log4j](https://github.com/apache/logging-log4j2). We want the application to be packed in a single [JAR](https://en.wikipedia.org/wiki/JAR_(file_format)) file without needing to link any of our dependencies manually.

We need to write a custom Gradle Task to merge our code with the third-party code that our application depends on because the default task from Java Gradle plugin doesn't do that automatically.

## How to run

| Description | Command |
| :--- | :--- |
| Generate JAR file | `./gradlew jar` |
| Generate Fat JAR file | `./gradlew fatJar` |
| Run JAR file | `java -jar <file.jar>` |
| Inspect JAR dependencies | `jdeps <file.jar>` |

> Note: The expected output from jdeps for both JAR files is in docs/ directory.

## Preview

Output from JAR file:

```
$ java -jar build/libs/poc-gradle-jar.jar hello JAR world!
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/logging/log4j/LogManager
	at com.example.Main.<clinit>(Main.java:8)
Caused by: java.lang.ClassNotFoundException: org.apache.logging.log4j.LogManager
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 1 more
```

Output from Fat JAR file:

```
$ java -jar build/libs/poc-gradle-jar-all.jar hello JAR world!
16:16:33.066 [main] INFO  com.example.Main - hello
16:16:33.067 [main] INFO  com.example.Main - JAR
16:16:33.067 [main] INFO  com.example.Main - world!
```
