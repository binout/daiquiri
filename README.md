Daiquiri
========

Daiquiri provides some test utilities complement java mock framework such as Mockito.
The project is under license [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0).

More information : [http://binout.github.com/daiquiri/](http://binout.github.com/daiquiri/)

Examples : [https://github.com/binout/daiquiri-examples](https://github.com/binout/daiquiri-examples)

BuildHive
---------
https://buildhive.cloudbees.com/job/binout/job/daiquiri/

[![Build Status](https://buildhive.cloudbees.com/job/binout/job/daiquiri/badge/icon)](https://buildhive.cloudbees.com/job/binout/job/daiquiri/)

Release note
------------

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

* Add @MockContext instead of calling of Daiquiri.Naming.mockIntiialContext
* Manage @Resource annotation using mocked Context
* Manage lifecycle annotations @PostContruct, @PreDestroy in unit testing
