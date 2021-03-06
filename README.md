# 1. Anwendungsbereich

Zu erstellen ist ein Softwaresystem zur Verwaltung von medizinischen Geräten sowie der Bestände von Sanitätsmaterialien in einem DRK-Ortsverein (Auftraggeber). Die Software soll eine bestehende, EXCEL-basierte Lösung ablösen. Ausdrucke der aktuell genutzten EXCEL-Arbeitsblätter finden sich im ILIAS-Lernraum des Programmierprojektes. Im Dialog mit dem Auftraggeber ist zu klären, ob darüber hinaus auch die Verwaltung von Materialien für die Betreuung unverletzter betroffener Personen in Krisensituationen im Rahmen des Programmierprojektes realisiert werden kann.

Die Software soll die nachfolgenden Anwendungsfälle unterstützen:

## Administration der benötigten Stammdaten

Geräte, Materialarten, (gegebenenfalls Lager- bzw. Standorte von Materialien und Geräten), Benutzer des Softwaresystems, Benutzerrollen und Benutzerrechte

## Pflege der Bestandsdaten

Verbuchen von Einlagerungen und Entnahmen von Material, Protokollierung vorgenommener Geräteprüfungen
Benachrichtigungsfunktionen

## Rechtzeitige Benachrichtigung

bei Unterschreiten von Mindestbeständen, Erreichen von Mindesthaltbarkeitsdaten bei Materialien sowie von Prüfterminen bei Geräten und Generierung von Bestelllisten

## Erstellen von Inventarlisten für Geräte und Materialien

Mit dem Auftraggeber zu klären ist ferner, inwieweit Bewegungsdaten im System vorzuhalten sind und eine Protokollierung (wer, wann?) der im System vorgenommenen Buchungen erfolgen soll.


# 2. Auftrag

a. Führen Sie ein Gespräch mit dem Auftraggeber, protokollieren Sie dieses und dokumentieren Sie die erhobenen funktionalen und nicht funktionalen Anforderungen an ihr System systematisch.

b. Erarbeiten Sie ein Datenbankschema, das der unter **1.** beschriebenen Aufgabenstellung gerecht wird, implementieren Sie dieses Schema in Form einer relationalen Datenbank und füllen Sie diese mit geeigneten Testdaten.

c. Erstellen Sie ein Softwaresystem, mit dem alle unter **1.** aufgeführten Anwendungsfälle unterstützt werden.


# 3. Weitere Arbeitsergebnisse

Neben der Software müssen Sie eine Dokumentation abgeben, in der

a. die mit Auftraggeber und Betreuer geführten Gespräche protokolliert sind

b. die wesentlichen Aspekte Ihres Softwareentwurfs erläutert werden.

c. der Quellcode beschrieben ist (Dokumentation im Quellcode reicht aus. Sorgen Sie dafür, dass im Quellcode erkenntlich ist, welche(r) Programmiere(in) für die jeweilige Klasse/ Methode verantwortlich ist).

d. für Nutzer die Installation der Software und die wesentlichen Programmfunktionen erläutert werden (Nutzerhandbuch bzw. Quickguide)

e. ein Testbericht enthalten ist.

Allgemeiner Hinweis: In Ihrer Dokumentation muss immer erkennbar sein, welcher Autor für welchen Abschnitt verantwortlich ist. Erstellen Sie dazu eine tabellarische Übersicht und lassen diese in Ihrer Einleitung mit einfließen.

# 4. Entwurf

## 4.1 Logbuch
- [Zeitplan](./logbook/)
- [13.10.2016](./logbook/01-meeting-13-10-2016.md)
- [20.10.2016](./logbook/02-meeting-20-10-2016.md)
- [25.10.2016](./logbook/03-meeting-25-10-2016.md) **(Kick-Off Meeting)**
- [28.10.2016](./logbook/04-meeting-28-10-2016.md)
- 15.11.2016 **(1. Meilenstein Meeting)**
- 29.11.2016 **(2. Meilenstein Meeting)**
- 20.12.2016 **(3. Meilenstein Meeting)**

## 4.2 Hintergrund
- [Anforderungen](./modellierung/Requirements/) **(ACK)**
- [Use-Case-Beschreibung](./modellierung/UseCases/) **(DOING)**
- Use-Case-Diagramme **(TODO)**
- [Sequenzdiagramme](./modellierung/UML/Sequenz/) **(ACK)**

## 4.3 Softwarearchitektur
- [SQL-Aufruf](./datenbank/) **(ACK)**
- [ER-Model](./modellierung/UML/ER/ER-Model.jpg) **(ACK)**
- [EER-Model](./modellierung/UML/EER/EER-Model.jpg) **(ACK)**
- [Architekturmuster](./modellierung/Architecture/) **(ACK)**
- [Klassendiagramm](./modellierung/UML/Class/Class-Model.jpg) **(ACK)**

## 4.4 User Interface
- [UI Mockups](./modellierung/Mockups/) **(ACK)**
- [UI Screenshots](./screenshots/) **(ACK)**

# 5. Implementierung
- [Übersicht](./source/)
- [Desktop Applikation](./source/stockManagement-desktop/)
- [Worker](./source/stockManagement-worker/)
- [Web Applikation](./source/stockManagement-online/)
- [CSV Parser](./source/stockManagement-importer/python/)
