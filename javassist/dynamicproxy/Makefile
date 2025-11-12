compile:
	javac -cp ../javassist.jar:. *.java

clean:
	rm -rf *.class
	rm -rf *.jar

make-jar: clean compile
	jar -cfm Premain.jar manifest.txt Premain.class

run: make-jar
	java -cp ../javassist.jar:. -javaagent:Premain.jar javassist.tools.reflect.Loader Main
