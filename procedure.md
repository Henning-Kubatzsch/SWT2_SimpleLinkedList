# Maven -Compiler und Testvorgänge anstoßen
Um den Compiler Vorgang anzustoßen, finden wir in der IDE (IntelliJ) unter Maven → Plugin → compiler den richtigen Unterpunkt. Alternativ nutzen wir über die Kommandozeile den Befehl -mvn compile.
Den Testvorgang starten wir in der IDE unter Maven → Lifecycle → test.

# JUnit 5/ AssertJ Dependency
Um Junit 5 und AssertJ nutzen zu können werden jeweils in der pom.xml dependencies eingefügt. Jeder Eintrag hat folgende Unterpunkte:
- groupId: Einzigartiger Identifier der Gruppe/Organisation, welche das Project entwickelt haben. 
- artifactId: Identifiziert das Artefakt.
- version: Gibt die Version des Artefakts an.

# JaCoCo
- konfigurieren in Maven/IDE
- Welche Abdeckung wird unterstützt, wie konfigurieren?

- Während des BUILD verbindet sich ein JaCoCo-Agent mit der JVM. JaCoCo kann sehen welche Klassen aufgerufen und welche Lines ausgeführt werden. Damit werden Code-Statistiken gesammelt.
- Um Jacoco in der IDE zu konfigurieren werden die entsprechenden Dependencies und Plugins in der pom.xml deklariert. Der JaCoCo Java Agent wird Abdeckungsinformation sammeln, wenn das maven-surefire-plugin die Tests durchläuft.

# JACOCO HOW TO:
- Nacheinander wird MAVEN CLEAN, MAVEN TEST ausgeführt. Der Report liegt dann unter target → site → jacoco → index.html.

# Visualisierung der Code-Coverage
- mit dem Test t: ```MoreRun/Debug -> Run 't' with Coverage```
