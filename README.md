# NTRU implementation in Java
We are using NTRU jar library for this project.

You'll need Java 1.6 to run the project, also please make sure that you use Maven 3.2.5 (this is the last version of maven that supports Java 6). If you use an older version of maven, you will potentially have issues with TLS version of maven repo (they upgraded to TLS 1.3 and you will get `Received fatal alert: protocol_version` error)

```sh
#To install dependencies
mvn clean install
 ```

```sh
#To Run the project (Please replace <username>)
/usr/lib/jvm/jdk1.6.0_45/bin/java -javaagent:/snap/intellij-idea-ultimate/420/lib/idea_rt.jar=44769:/snap/intellij-idea-ultimate/420/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/jdk1.6.0_45/jre/lib/charsets.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/deploy.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/ext/dnsns.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/ext/localedata.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/javaws.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/jce.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/jsse.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/management-agent.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/plugin.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/resources.jar:/usr/lib/jvm/jdk1.6.0_45/jre/lib/rt.jar:/home/<username>/FIEKMASTER/information-security/ntru/target/classes:/home/<username>/.m2/repository/net/sf/ntru/ntru/1.2/ntru-1.2.jar:/home/<username>/.m2/repository/org/bouncycastle/bcprov-jdk16/1.46/bcprov-jdk16-1.46.jar org.fiek.Main
```