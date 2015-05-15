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
* [JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Guice](https://github.com/google/guice)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [Jackson](https://github.com/FasterXML/jackson)
* [Guava](https://github.com/google/guava)

#### Features
* http routing
* eventbus
* Redis connect
* MySQL connect
* send http request
* testing
