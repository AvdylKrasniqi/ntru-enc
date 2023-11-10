# NTRU implementation in Java
We are using NTRU jar library for this project.

You'll need Java 1.6 to run the project, also please make sure that you use Maven 3.2.5 (this is the last version of maven that supports Java 6). If you use an older version of maven, you will potentially have issues with TLS version of maven repo (they upgraded to TLS 1.3 and you will get `Received fatal alert: protocol_version` error)

```sh
#To install dependencies
mvn clean install
 ```