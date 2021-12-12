#Freitagsaufgabe

Der Auftraggeber wünscht sich einen Shop-Service, um seine Produkt-Bestellungen verwalten zu können.
Er möchte auf der Konsole ausgeben lassen können:

- ein einzelnes Produkt
- alle Produkte
- Zusätzlich kann er eine neue Bestellung aufgeben. Für jede neue Bestellung möchte er die entsprechenden Produkt-Ids mitangeben.

Weiterhin möchte er:

- sich eine einzelne Bestellung anhand ihrer id ausgeben lassen.
- alle Bestellungen ausgeben lassen können.

##Tipps
Implementiere das Bestellsystem (natürlich mit Tests!).

- Erstelle eine Klasse ProductRepo, die eine Product Liste enthält.
- Erstelle eine Klasse OrderRepo, die eine Order Liste enthält
- Erstelle eine Klasse ShopService, über die wir eine neue Order aufgeben können.
- throw eine Exception, wenn nicht-existente Produkte bestellt werden
##Bonus

- Nutze für die get Methoden ein Optional
- Nutze anstelle einer Product Klasse ein Interface und implementiere verschiedene Ausführungen
- Nutze UUID für generierte und einzigartige ID´s.