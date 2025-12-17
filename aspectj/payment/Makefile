clean:
	rm -rf *.class

compile: clean
	javac *.java
	ajc -21 -cp ../aspectjrt.jar *.aj *.java

run: compile
	java -cp ../aspectjrt.jar:. Main
