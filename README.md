REST API server template of Vert.x 3.x
===========

[![Build Status](https://travis-ci.org/takecy/vertx3-api-server.svg)](https://travis-ci.org/takecy/vertx3-api-server)

![](https://img.shields.io/badge/java-1.8+-blue.svg?style=flat-square)
![](https://img.shields.io/badge/vert.x-3.0+-blue.svg?style=flat-square)

<br/>
## Overview
RESTful API server template of [Vert.x](https://github.com/eclipse/vert.x) 3+.  
Based on was operational experience of Vert.x 2.x, the template application is made in the configuration, such as use in a production environment.  

<br/>

## Structure
Vert.x is realy friendly Reactive programing.  
So you should use [vertx-rx](https://github.com/vert-x3/vertx-rx).

### Dependencies
#### Application
* [JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Guice 4+](https://github.com/google/guice)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [Jackson 2+](https://github.com/FasterXML/jackson)
* [Guava](https://github.com/google/guava)

#### Build
* [Maven](https://maven.apache.org/) (back from Gradle)

#### Testing
* [Junit 4](https://github.com/junit-team/junit)
* [Jacoco](https://github.com/jacoco/jacoco)

#### CI
* [Travis](https://travis-ci.org/)
* [Jenkins](https://jenkins-ci.org/)

<br/>
### Features
* dependency injection
* continuous integration
* http routing
* eventbus
* send http request
* Redis connect
* MySQL connect
* testing


<br/>
## License
[MIT](./LICENSE)