clean:
	rm -rf *.class
	rm -rf *.jar

compile: clean
	javac -cp ../javassist.jar:. *.java

make-jar: compile
	jar cmf manifest.txt Agent.jar Agent.class

run: make-jar
	java -cp ../javassist.jar:. -javaagent:Agent.jar Main
