clean:
	rm -rf *.class

original: clean
	javac *.java
	java Main

compile: clean
	ajc -21 -cp ../aspectjrt.jar *.aj *.java

run: compile
	java -cp .:../aspectjrt.jar Main
