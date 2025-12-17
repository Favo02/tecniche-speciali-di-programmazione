clean:
	rm -rf *.class

compile: clean
	ajc -21 -cp ../aspectjrt.jar *.aj *.java

original: clean
	javac *.java
	java Main

run: compile
	java -cp ../aspectjrt.jar:. Main
