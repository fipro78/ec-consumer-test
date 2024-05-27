# Eclipse Collections Consumer Test

This repository contains some simple scenarios to verify that the Eclipse Collections artifacts can be consumed in various deployment scenarios.

The first step is to run the build to ensure that the dependency resolution works as intended.

```
mvn clean verify
```

Switch to the created _result_ folder in the project root. Now you can execute the different build variants from command line:

## Plain Java

First of all it is possible to execute a plain Java application from classpath and from modulepath.

### Run the example from classpath

```
java -cp ./jars/* org.fipro.ec_consumer_test.ec_consumer_main.SortInput Mohammad Donald Hiroshi Craig Sirisha Nikhil
```

### Run the example from modulepath

```
java --module-path ./jars --module ec.consumer.main/org.fipro.ec_consumer_test.ec_consumer_main.SortInput Mohammad Donald Hiroshi Craig Sirisha Nikhil
```

## JPMS

It is also possible to create a custom JRE using `jlink`.

To build a custom JRE from the modulepath, execute the following command:

```
jlink --add-modules=ALL-MODULE-PATH --module-path jars --no-header-files --no-man-pages --output custom_jre
```

Run the example by using the created custom JRE

```
custom_jre/bin/java --module ec.consumer.main Mohammad Donald Hiroshi Craig Sirisha Nikhil
```

## OSGi

The Eclipse Collections API and Impl artifacts can be consumed as bundles in an OSGi application.

Run the OSGi application example

```
java -Djava.util.logging.config.file=osgi/logging.properties -jar osgi/app.jar Mohammad Donald Hiroshi Craig Sirisha Nikhil
```