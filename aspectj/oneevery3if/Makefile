clean:
	rm -rf *.class

compile:
	ajc -21 -cp ../aspectjrt.jar:. *.aj *.java

run: compile
	java -cp ../aspectjweaver.jar:. Main
