## LSP in VSCode

Impostare il setting `java.project.referencedLibraries` come un array dei path dei jar.

Altrimenti, dalla command palette, `Java: Configure Classpath` ed importare i jar dalla tab `Libraries`.

## Reflection

Compilare prima tutto con `javac *.java` e poi la classe col main `java Main`, capendo se servono argomenti da CLI o meno.

> ![WARNING]
> I packages sono il male. Sempre. Mai metterli.

## Javassist

> ![CAUTION]
> Il manifest deve avere una linea vuota alla fine, altrimenti viene persa l'ultima riga.

```manifest
Premain-Class: Premain
\n <-- importante!!!!
```

> ![NOTE]
> Assumendo che javassist.jar sia installato nella stessa cartella padre del progetto `../`.

```makefile
compile:
	javac -cp ../javassist.jar:. *.java

clean:
	rm *.class
	rm *.jar

make-jar: clean compile
	jar -cfm Premain.jar manifest.txt Premain.class

run: make-jar
	java -cp ../javassist.jar:. -javaagent:Premain.jar javassist.tools.reflect.Loader Main
```

## BCEL

BCEL non lo so usare, ma ho capito che oltre al jar di bcel servono altre dipendenze (`commons-io`, `commons-lang3`), da includere anche loro nel classpath.

## Aspectj

> ![NOTE]
> Assumendo che aspectj sia installato in `/opt/aspectj1.9`.

> ![WARNING]
> Nei classpath, la `~` non viene risolta.

### Compilare con `ajc`

```bash
ajc -21 -cp /opt/aspectj1.9/lib/aspectjrt.jar *.aj *.java
```

- -21: versione
- -cp: classpath del jar di aspectj
- aspetti (PRIMA dei java)
- sorgenti java

### Eseguire con `aj`

> ![CAUTION]
> Di default `aj` (che è uno script bash) non include il classpath `.` quando esegue, non trovando quindi le classi nella cartella corrente.
> Per fixare, modificare manualmente il file `/opt/aspectj1.9/bin/aj`, appendendo `:.` al `-classpath`.

```bash
aj Main
```

### Eseguire con `java`

Dato che i compilati `.class` sono dei file Java validi, si può anche eseguire con `java`.
Bisogna però includere il classpath del weaver di aspectj.

```bash
java -cp /opt/aspectj1.9/lib/aspectjweaver.jar:. Main
```

### Con package

In generale per Java, quando bisogna compilare/eseguire un progetto con packages, bisogna essere alla root del progetto (non dentro la cartella coi file).

Ad esempio:

```
some_folder/
└── test/
    └── Main.java (definito con package test)
    └── Aspect.java (definito con package test)
```

Per eseguirlo bisogna spostarsi nel "classpath root" in questo caso `some_folder`, includendo il classpath `.`.
