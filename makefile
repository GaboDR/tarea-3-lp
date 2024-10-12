JAVAC = javac
JAVA_FILES = CentroGalactico.java Planeta.java Helado.java Jugador.java MapaGalactico.java Nave.java NoJavaSky.java Oceanico.java Radiactivo.java TieneAsentamientos.java Volcanico.java
MAIN_CLASS = NoJavaSky

all:compile run

compile:
	$(JAVAC) $(JAVA_FILES)

run:
	java $(MAIN_CLASS)

clean:
	rm -f *.class