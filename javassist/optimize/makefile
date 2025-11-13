clean:
	rm -rf *.class

compile: clean
	javac -cp ../javassist.jar:. *.java

run: compile
	java -cp ../javassist.jar:. ByteCodeOptimizer TestClass
	java TestClass
	mv optimized/TestClass.class TestClass.class
	java TestClass
