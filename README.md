REST API server template of Vert.x 3.x
===========

[![Build Status](https://travis-ci.org/takecy/vertx3-api-server.svg)](https://travis-ci.org/takecy/vertx3-api-server)


<br/>
Overview
---
RESTful API server template of [Vert.x](https://github.com/eclipse/vert.x) 3+.  
Based on was operational experience of Vert.x 2.x, the template application is made in the configuration, such as use in a production environment.  

<br/>

Structure
---
Vert.x is realy friendly Reactive programing.  
So you should use [vertx-rx](https://github.com/vert-x3/vertx-rx).

#### Dependencies
##### Application
* [JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Guice 4+](https://github.com/google/guice)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [Jackson 2+](https://github.com/FasterXML/jackson)
* [Guava](https://github.com/google/guava)

##### Build
* [Maven](https://maven.apache.org/) (back from Gradle)

##### Testing
* [Junit 4](https://github.com/junit-team/junit)
* [Jacoco](https://github.com/jacoco/jacoco)

##### CI
* [Travis](https://travis-ci.org/)

<br/>
#### Features
* http routing
* eventbus
* Redis connect
* MySQL connect
* send http request
* testing
