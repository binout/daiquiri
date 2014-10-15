Daiquiri
========

Daiquiri provides some test utilities complement java mock framework such as Mockito.
The project is under license [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0).

More information : [http://binout.github.com/daiquiri/](http://binout.github.com/daiquiri/)

BuildHive
---------
https://buildhive.cloudbees.com/job/binout/job/daiquiri/

[![Build Status](https://buildhive.cloudbees.com/job/binout/job/daiquiri/badge/icon)](https://buildhive.cloudbees.com/job/binout/job/daiquiri/)

Release note
------------

* daiquiri-0.2.1 :
    - change groupId : io.github.binout
    - deploy to Maven Central

* daiquiri-0.2 :
    - add DaiquiriAnnotations
    - @MockContext : to mock an InitialContext or an InitialDirContext
    - manage @Resource with @MockContext
    - @Tested : to instantiate the tested class, @PostConstruct can be called

* daiquiri-0.1.2 :
    - minor changes of signature of Daiquiri.Naming.mockInitialContext and Daiquiri.Naming.mockInitialDirContext

* daiquiri-0.1.1 :
    - add Apache 2.0 license

* daiquiri-0.1 :
    - init Daiquiri main class
    - mock InitialContextFactory for new InitialContext()
    - mock InitialContextFactory for new InitialDirContext()

Future
------

* Try to mock FileSystem with java 7 filesystemprovider
    - http://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/filesystemprovider.html
