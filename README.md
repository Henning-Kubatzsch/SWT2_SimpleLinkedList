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

# Spotbugs
- Sucht Fehler in einem Java-Program, indem es den Quellcode auf das Vorkommen bestimmter "Bug-Patterns" überprüft. Diese "Bug-Patterns" sind Code-Ausschnitte, welche wahrscheinlich unsauber oder fehlerhaft sind. 
- Zum Konfigurieren werden Plugin und Dependency in der pom.xml hinzugefügt.
- Spotbugs als Teil von MAVEN TEST mit dem Goal SPOTBUGS ausgeführt, welches einen Report über die gefundenen potentiellen Fehler erstellt.
- Wir verwenden zusätzlich noch das Goal GUI, um den Report übersichtlich in der grafischen Oberfläche anzeigen zu lassen.

# Spotbugs-Ergebnisse für die ursprüngliche SimpleLinkedList
- Iterator next() method can't throw NoSuchElementException (Zeilen 61-62) \
  Die Methode versucht auf das nächste Listenelement zuzugreifen, ohne vorher zu prüfen, ob das Element existiert. Statt auf ein nicht existentes Element zuzugreifen sollte eine NoSuchElementException geworfen werden.
- Useless control flow to next line (Zeile 34) \
  Das Semikolon nach dem If-Ausdruck signalisiert einen leeren Funktionsblock. Die nachfolgende Anweisung wird also in jedem Fall ausgeführt, ohne Beachtung des If-Ausdrucks. 
