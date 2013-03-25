#Web-basierte Anwendungen 2: Verteilte Systeme

##Dokumentation
Jorge H. F. Pereira



##Aufgaben
###Aufgabe 1
**Wohlgeformtheit**  
Der Aufbau des XML-Dokuments ist entscheident. Elemente sollten geschickt in anderen Elementen verschachtelt werden so, dass ein semantisch korrekter Aufbau entsteht.
Als Beispiel sei eine Liste von Personen zu nennen. Es kann ein Element mit dem Typ/Namen "PersonsList" geben, welches als Wrapper-Element fungiert und mehrere Kindelemte vom Typ/Namen "Person" führt.
Dabei ist wichtig festzulegen, dass nur Elemente vom Typ/Namen "Person" als Kindelemente akzeptiert werden, da sonst bei anderen Elemententypen die Bedeutung des Wrapper-Elements verloren geht. Nämlich die, dass das Element eine Liste eines bestimmten Typs ist.
Als weitere Beispiel für Wohlgeformtheit ist die Existenz von nur einem Wurzelknoten.

**Validität**  
Das XML-Dokument ist syntaktisch korrekt aufgebaut und folgt zuvor festgelegten Regeln und Definitionen. Dazu wird das Dokument auf die von einer Grammatik beschriebenen Form überprüft.

**Namespaces**  
Namespaces werden eingesetzt, um eventuelle Namenskonflikte zu vermeiden, wenn man mit XML-Dokumenten unterschiedlicher Herkunft arbeitet bzw. diese verarbeitet.
Jedem Element kann dabei ein "prefix" gegeben werden, klar getrennt mit einem Doppelpunkt.

Als Beispiel:
```
<fh:kopf xmlns:fh="http://www.fh-koeln.de/definition">
</fh:kopf>
```

Zusätzlich muss dem Element über das Attribut "xmlns", ebenfalls durch ein Doppelpunkt mit dem verwendeten Namespace-Prefix verbunden, ein eindeutiger Wert zugewiesen werden.
Dabei bietet es sich an eine Web-Adresse anzugeben, die ein Dokument referenziert, unter dem weitere Informationen bezüglich des Namespaces zu finden sind.



###Aufgabe 2
**a)**

```
<?xml version="1.0" encoding="UTF-8"?>
<registrierung>
	<gruppenleiter>
		<vorname>Hugo</vorname>
		<nachname>Reyes</nachname>
		<email>hugo@island.lost</email>
		<geburtsdatum>1960-08-01</geburtsdatum>
		<erfahrung>Amateur</erfahrung>
		<schlagzeug>vorhanden</schlagzeug>
		<anmerkung></anmerkung>
	</gruppenleiter>
	<personen>
		<person>
			<vorname>John</vorname>
			<nachname>Doe</nachname>
			<email>john@island.lost</email>
			<geburtsdatum>1973-08-02</geburtsdatum>
			<erfahrung>Amateur</erfahrung>
			<schlagzeug>nicht vorhanden</schlagzeug>
			<anmerkung></anmerkung>
		<person>
		<person>
			<vorname>Jane</vorname>
			<nachname>Doe</nachname>
			<email>jane@island.lost</email>
			<geburtsdatum>1974-08-10</geburtsdatum>
			<erfahrung>Amateur</erfahrung>
			<schlagzeug>nicht vorhanden</schlagzeug>
			<anmerkung></anmerkung>
		<person>
	</personen>
</registrierung>
```


**b)**

```
{
	"gruppenleiter": {
		"vorname": "Hugo",
		"nachname": "Reyes",
		"email": "hugo@island.lost",
		"geburtsdatum": "1960-08-01",
		"erfahrung": "Amateur",
		"schlagzeug": "vorhanden",
		"anmerkung": ""
	},
	"personen":
		[{
			"vorname": "John",
			"nachname": "Doe",
			"email": "john@island.lost",
			"geburtsdatum": "1973-08-02",
			"erfahrung": "Amateur",
			"schlagzeug": "nicht vorhanden",
			"anmerkung": ""
		},
		{
			"vorname": "Jane",
			"nachname": "Doe",
			"email": "jane@island.lost",
			"geburtsdatum": "1974-08-10",
			"erfahrung": "Amateur",
			"schlagzeug": "nicht vorhanden",
			"anmerkung": ""
		}]
}
```


###Aufgabe 3
**a)**

```
<?xml version="1.0" encoding="UTF-8"?>
<rezept>
	<rezeptname>Lenchen's Schokoladenkuchen</rezeptname>
	<fotos>
		<foto>
			<benutzername>Gartenliebe</benutzername>
			<adresse>http://www.url.zum/foto1.jpg</adresse>
		</foto>
		<foto>
			<benutzername>Gartenzwerg123</benutzername>
			<adresse>http://www.url.zum/foto2.jpg</adresse>
		</foto>
		<foto>
			<benutzername>Honigliebe19</benutzername>
			<adresse>http://www.url.zum/foto3.jpg</adresse>
		</foto>
		<foto>
			<benutzer>Gartenhaeuschen78</benutzer>
			<adresse>http://www.url.zum/foto4.jpg</adresse>
		</foto>
	</fotos>
	<arbeitszeit>60</arbeitszeit>
	<kochbackzeit></kochbackzeit>
	<ruhezeit></ruhezeit>
	<schwierigkeitsgrad>normal</schwierigkeitsgrad>
	<brennwert>295</brennwert>
	<portionen>16</portionen>
	<zutaten>
		<zutat>
			<name>Butter</name>
			<menge>200</menge>
			<einheit>g</einheit>
		</zutat>
		<zutat>
			<name>Zucker</name>
			<menge>200</menge>
			<einheit>g</einheit>
		</zutat>
		<zutat>
			<name>Schokolade, Blockschokolade</name>
			<menge>200</menge>
			<einheit>g</einheit>
		</zutat>
		<zutat>
			<name>Mehl</name>
			<menge>120</menge>
			<einheit>g</einheit>
		</zutat>
		<zutat>
			<name>Backpulver</name>
			<menge>0.5</menge>
			<einheit>TL</einheit>
		</zutat>
		<zutat>
			<name>Vanillezucker</name>
			<menge>1</menge>
			<einheit>Pkt.</einheit>
		</zutat>
		<zutat>
			<name>Eier</name>
			<menge>4</menge>
		</zutat>
	</zutaten>
	<zubereitung>Butter und Schokolade im Wasserbad schmelzen. Eier...</zubereitung>
	<kommentare>
		<kommentar>
			<benutzername>swieselchen90</benutzername>
			<geschrieben_am>2002-02-07T18:49:00.000+01:00</geschrieben_am>
			<nachricht>Habe....</nachricht>
		</kommentar>
		<kommentar>
			<benutzername>gartenwiesel</benutzername>
			<geschrieben_am>2002-02-10T19:20:45.000+01:00</geschrieben_am>
			<nachricht>Ist...</nachricht>
		</kommentar>
	</kommentare>
</rezept>
```

**b)**
Alle Rezepte haben immer einen Namen, eine Zutatenliste mit mindestens einer Zutat, eine Zubereitungsanleitung und eine Liste von Kommentaren.
Rezepte unterscheiden sich zum einen bei den Zutaten, genauer den Mengeneinheiten. Die Angaben sind nicht immer in Gramm und können manchmal sogar nicht einmal in Gramm angegeben sein. In einigen wenigen Fällen entfällt sogar die Einheiten- und die Mengenangabe komplett. Zutaten können auch als optional gekennzeichnet sein.
Bezüglich der Zutatenliste ist zusätzlich anzumerken, dass nicht alle Gerichte die selbe Anzahl an Zutaten hat.
Für den Zubereitungsvorgang kann eine ungefähre Zeitdauer angegeben werden, wobei das in Punkt a) entwickelte XML-Dokument davon ausgeht, dass eine Ganzzahl angegeben wird, die die Zubereitungszeit exakt in Minuten bestimmt.
Als weiterer Unterschied ist zu nennen, dass einige Elemente auch mal keinen Wert enthalten, wie z.B. der Brennwert, wenn dieser nicht bekannt ist.
Zuletzt kann es zu einem Rezept auch keine Fotos vom fertig gekochten Gericht geben, was ebenfalls auch für die Kommentare gilt.


**c)**
Zu aller erst sollte ein Entscheidungskriterium eingeführt werden, um besser unterscheiden zu können, ob Daten ihr eigenes Element erhalten, oder in eigenständige Attribute ausgelagert werden.
Dabei wird einem simplen Prinzip gefolgt. Daten, die für einen Menschen sichtbar/lesbar sein sollen, werden in Elementen geführt. Attribute hingegen werden nur für die Angabe von Metainformationen, wie z.B. zur Identifikation eines Elements, herangezogen.
Speziell bei der Mengenangabe einer Zutat, könnte man für das Element der Zutatenmenge ein Attribut für die Einheit einführen. Dies wäre sicherlich möglich, da sich die Einheit direkt auf die Menge bezieht und das Element quasi "modifiziert". Dennoch wird sich dafür entschieden die Einheit als eigenständiges Element anzugeben, da es, laut Entscheidungskriterium, um eine Angabe handelt, die der Mensch am Ende sehen/lesen kann. 

Alle Daten sind grundsätzlich auf schon vordefinierte simple-types abbildbar. 

**string** => Rezeptname, Zubereitungsanweisung, Kommentartext, Benutzername, Zutatenname, Einheit  
**dateTime** => Verfassungszeitpunkt (Kommentare)  
**positiveInteger** => Arbeitszeit, Koch-Back-Zeit, Ruhezeit, Brennwert und Portionen  
**anyURI** => Grafikadressen (Fotos)  
**decimal** => Zutatenmenge  

Bezüglich der Angaben über die Arbeitszeit, Koch-Back-Zeit, Ruhezeit und der Brennwert muss zudem beachtet werden, dass sie nicht unbedingt angegeben sein müssen.


Auf complex-types müssen zuletzt die Elemente abgebildet werden, die als Container-Elemente bzw. Listen-Elemente fungieren.
Dazu gehört die Fotoliste, die Zutatenliste und die Kommentarliste.
Zusätzlich muss, durch die Vorgabe mehrere Rezepte speichern zu können, eine Rezeptliste berücksichtigt werden. Da diesem Element kein weiteres Element übergeordnet ist, kann es als Wurzelelement in Betracht gezogen werden. 

Als eine Restriktion muss definiert werden, dass die Angabe einer negativen Zutatenmengen nicht erlaubt ist. Da die Zutatenmenge nicht immer ganzzahlig sein muss, wurde sich bewusst für den simple-type "decimal" entschieden. Dieser erlaubt aber negative Werte und muss deshalb auf positive Werte begrenzt werden.
Für die Schwierigkeitsangabe muss ebenfalls eine Restriktion definiert werden, da nur die drei Angaben "simpel", "normal" und "schwer" erlaubt sind.


**d)**

siehe  - misc/aufgabe3d.xsd -
	u. - misc/aufgabe3d.xml -



###Aufgabe 4

**a)**
Anhand des XML-Schemas wurde eine Klasse "RezeptType" generiert.
Hätte man die verschiedenen verschachtelten complex-types ausgelagert und mit einem Namen referenziert, hätte "xjc" mehrere Klassen generiert, nämlich für jeden complex-type eine.
Das hat er in diesem Fall nicht getan, da sich die complex-types verschachtelt im Oberdatentyp "rezeptType" befinden. Somit sind diese Klassen als statische verschachtelte Klassen (static nested classes) der "RezeptType"-Klasse zu finden.
Der Vorteil an dieser herangehensweise bzw. der Strukturierungsart des XML-Schemas liegt darin, dass nur eine Klasse generiert wird (die Klasse "ObjectFactory" nicht mitgezählt) und somit ein sauberer und übersichtlicher src-Tree gegeben ist.



**b)**

siehe - src/RezeptMain.java -


**c)**

siehe - src/RezeptMain.java -



###Aufgabe 5

Der Vorteil Daten in Formaten wie XML und JSON zu speichern liegt darin, dass sie leichter von Maschinen gelesen und weiterverarbeitet werden können.
Durch die fest vorgschriebene Struktur und Aufbau eines solchen Formats, kann auch eine leichtere Umwandlung in ein anderes Format ermöglicht werden.
Relevante Daten können so zudem auch schneller im Dokument lokalisiert und ggf. für die Weiterverarbeitung extrahiert werden, da sie einer einheitlichen Struktur folgen.

Im Vergleich zu JSON besitzen XML-Dokumente einen sehr hohen Overhead, was sich für Datenübertragungen negativ auswirken kann. Obwohl beide Formate vom Mensch gelesen werden können, ist das XML-Format, durch die Verwendung von Tags mit verdeutlichenden Namen, etwas leserlicher.
Über den Tagnamen ist für einen Menschen klarer, was ein Wert verdeutlichen soll. Das XML-Format ist im Vergleich zu JSON flexibler (Attribute, Kommentare, Verarbeitungsanweisungen). JSON folgt da mehr dem Key-Value-Prinzip, wobei aus der Angabe des Werts auch direkt sein Typ ersichtlich ist, da JSON nur eine kleine Auswahl an elementaren Datentypen vorsieht.
