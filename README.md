# Java EE: Getting Started : Module 03: Bootstrapping the Java EE Application

This module takes the installed tools to bootstrap an empty Java EE application and execute it.


## Demo 

* To bootstrap the application use the following Maven archetype : `mvn -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee7 -DarchetypeVersion=1.1 -DgroupId=com.pluralsight.java-ee-getting-started -DartifactId=bookstore-back -Dversion=1.0 -Darchetype.interactive=false --batch-mode -Dpackage=com.pluralsight.bookstore archetype:generate`. This command creates a Maven project structure under the `bookstore-back` directory.
* In the `pom.xml` add `<finalName>bookstore-back</finalName>` so we don't get a `bookstore-back-1.0` URL but just `bookstore-back`
* In the `pom.xml` change the versions of Java, Java EE and the Maven plugins with properties:
* ``` <properties> <version.java>1.8</version.java> <version.javaee>7.0</version.javaee> <!-- Plugins --> <version.compiler.plugin>3.8.0</version.compiler.plugin> <version.dependency.plugin>3.1.1</version.dependency.plugin> <version.war.plugin>3.2.2</version.war.plugin> </properties> ```


## Structure 

The BookStore application is divided into a Java EE REST back-end (`bookstore-back`) and an Angular front-end (`bookstore-front`).


### Bookstore Back 

The code of this module follows the [Maven](http://maven.apache.org/) directory structure. The `src/main/` directory contains the main source code while you will find the test class under `src/test/`. The `pom.xml` file is Maven specific and it describes the project and its dependencies.

Once [Maven](http://maven.apache.org/) and a [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) are installed, enter the following Maven commands:

* `mvn help:help`       : shows Maven help
* `mvn clean`           : cleans the `target` directory
* `mvn compile`         : compiles the code
* `mvn test`            : runs the test case (you need WildFly to be up and running)
* `mvn package`         : packages the code into a war file
* `mvn clean package`   : executes a clean and then a package

Once [Wildfly](http://wildfly.org/) is installed, deploy the war file and go to [http://localhost:8080/bookstore-back/]()


### Bookstore Front 

The code of this module follows the [Angular CLI](https://github.com/angular/angular-cli) directory structure. The `src/` directory contains the main source code. The `package.json` file is Node specific and it describes the project and its dependencies.
