# Swingy

GUI applications with the SWING framework. Implement a minimalistic text-based RPG game.

- Respect the Model-View-Controller design pattern.
- Automated build with Maven.
- Annotation based user input validation.

## Compiling using javac and java

- find -name *.java > sources.txt
- javac @sources.txt
- java ...

## Using Maven to build the project

mvn archetype:generate -DgroupId=com.cglanvil.app -DartifactId=swingy -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

## Using Maven to build the jar file

mvn clean package

## Running the jar

java -jar target/swingy-1.0-SNAPSHOT.jar 

## To do

- need to get validation working - wait a bit
- need to add more views - don't think I do
- need to combine models - done
- model needs useful functions
