Scala Module for TCD Functional Programming Course
===============

This repo will allow you to set yourself up for the Scala Module
of the TCD Functional Programming Course.

Please install [git](http://git-scm.com/downloads) on your laptop and clone the repo ...

    > git clone https://github.com/rolandtritsch/scala-tcd-funcprog.git

... to &lt;location of your choice&gt;.

Please install [sbt](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html) on your laptop and compile the setup by typing (below is for Mac OS) ...

    > cd <location of your choice>/scala-tcd-funcprog
    > mkdir <your first name>.<your last name>
    > cp -R roland.tritsch/* <your firstname>.<your lastname>
    > cd <your firstname>.<your lastname>/0.setup
    > sbt "compile"

... and you should see a successful compile. You can then try to run it ...

    > sbt "run"

... and should see the familiar "Hello World" output. You can then try to test it ...

    > sbt "test"

... which should fail.

Homework
--------

1. Make the test pass. Change the source code in src/test/scala and run sbt test again.
1. Change Hello.scala to look at the first argument and make it print "Hello " + firstArg. Note: To run it you need to put the arg into quotes with the run (e.g. > sbt "run world").
1. Bonus: Get a github account, send me an email (roland@tritsch.org), so that I can add you as a collaborator and commit/push your source code to the repo (to figure out how to do that is a an excerise for the reader :)).

Resources
---------

* [Scala Getting Started](http://www.scala-lang.org/node/166)
* [Scala Documentation](http://www.scala-lang.org/node/197)
