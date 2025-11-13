clean:
	rm -rf *.jar
	rm -rf *.class

compile: clean
	javac -cp ../javassist.jar:. *.java

build-jar: compile
	jar cfm CrazyAgent.jar MANIFEST.MF CrazyAgent.class

run: compile build-jar
	java -cp ../javassist.jar:. -javaagent:CrazyAgent.jar javassist.tools.reflect.Loader Main
