# project-base

## Description
Project base to build REST services with Spring boot.

## Usage
The rest service can be easily tested by running:
```
mvn spring-boot:run
```
Or by generating the war and deploying in an application server:
```
mvn clean package
```
There are also unit and integration test which can be performed by:
```
mvn test
```

## Maven archetype
This base project can be used to create an archetype with the following command:
```
mvn archetype:create-from-project  -Darchetype.properties=archetype.properties
```
Then, we can install the archetype:
```
cd target/generated-sources/archetype/
mvn install
```
And use it for a new project:
```
mvn archetype:generate -DarchetypeCatalog=local
```

## Improvements
- Set log4j.
- Convert to maven multimodule.
- Suggestions?
- ...
