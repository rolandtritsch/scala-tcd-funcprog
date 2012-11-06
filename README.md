# Scala Module for TCD Functional Programming Course

## Lab0 - Setup

This repo will allow you to set yourself up for the Scala Module
of the TCD Functional Programming Course.

Please install [git](http://git-scm.com/downloads) on your laptop and clone the repo ...

    > git clone https://github.com/rolandtritsch/scala-tcd-funcprog.git

... to &lt;location of your choice&gt;.

Please install [sbt](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html) on your laptop and compile the setup by typing (below is for Mac OS) ...

    > cd <location of your choice>/scala-tcd-funcprog
    > mkdir <your first name>.<your last name>
    > cp -R roland.tritsch/0.setup <your firstname>.<your lastname>
    > cd <your firstname>.<your lastname>/0.setup
    > sbt "compile"

... and you should see a successful compile. You can then try to run it ...

    > sbt "run"

... and should see the familiar "Hello World" output. You can then try to test it ...

    > sbt "test"

... which should fail.

### Homework

1. Make the test pass. Change the source code in src/test/scala and run sbt test again.
1. Change Hello.scala to look at the first argument and make it print "Hello " + firstArg. Note: To run it you need to put the arg into quotes with the run (e.g. > sbt "run world").
1. Bonus: Get a github account, send me an email (roland@tritsch.org), so that I can add you as a collaborator and commit/push your source code to the repo (to figure out how to do that is a an excerise for the reader :)).

### Resources

* [Scala Getting Started](http://www.scala-lang.org/node/166)
* [Scala Documentation](http://www.scala-lang.org/node/197)

## Lab1 - Rewriting a Java program in Scala - Josephus Problem

With Lab1 we want to rewrite a Java program in Scala. The program is an implementation of a solution to [Josephus problem](http://en.wikipedia.org/wiki/Josephus_problem). To make it work you need to ...

    > cd <location of your choice>/scala-tcd-funcprog
    > git pull
	> git checkout labs
    > cp -R roland.tritsch/1.rewrite <your firstname>.<your lastname>
    > cd <your firstname>.<your lastname>/1.rewrite/java
    > sbt "run 41 3"

... and you should see the solution of 31 (means you need to be soldier 31 to survive).

Please take a look at the Java source code to understand the solution. 

You then need to ...

    > cd <your firstname>.<your lastname>/1.rewrite/scala
	> sbt "run 41 3"
	> sbt "test"

... and both will fail. Please flesh out the code in Josephus.scala to make the program work and the test pass.

### Hints

* Use the source code from the Java solution as a template.
* Use the provided RingIterator to implement the solution.
* Use > sbt console to start a repl and play with RingIterator to understand how it works and behaves.
* Use the source code from Hello.scala as a template for the main.

## Lab2 - Write a Scala program that uses Java

Java integrates very well with Scala (or (depending on your point of view) the other way around). With Lab2 we want to show how to use Java from Scala. The aim is to rewrite the solution from Lab1 using Java collection types, namely ...

* List and LinkedList from java.util and
* LoopingListIterator from org.apache.commons.collections.iterators

### Hints

* Use mvnrepository.com to find out how to update the build.sbt with the library dependency for the Apache common collections lib.
* Use the import ...{Original => Now} syntax to rename the classes.
* Use asInstanceOf[T] to cast java.lang.Object into something that you want/need.
