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

Hier ist klar, dass sich der Gruppenleiter von den restlichen Gruppenmitgliedern unterscheidet. Dazu wird für den Gruppenleiter ein Element "gruppenleiter" eingeführt und für die restlichen Personen ein Element "person".
Eine Besonderheit von einer Gruppe ist die, dass sie sich aus keinen, nur einer oder mehrere Personen zusammensetzen kann. Diese Besonderheit wurde durch die Kapselung der einzelnen "person"-Elemente in einem übergeordneten Element "personen" angegangen. Man hat somit eine Art Container-Element eingeführt, welches keine, nur einen oder mehrere Kindelemente haben kann.  
Man hätte natürlich auch nur ein Element für den Leiter sowie für weitere Personen einführen können. Dies würde sich auf den ersten Blick auch anbieten, da sie sich an den eingegebenen Daten nicht unterscheiden. Für beide Typen müssen die selben Datenfelder ausgefüllt werden. Zum Unterscheiden würde für das Element dann ein Attribut mit dem Namen "rolle" eingeführt werden.
Somit könnte dem Attribut für den Gruppenleiter z.B. der Wert "leiter" und alle weiteren Personen der Wert "teilnehmer" zugewiesen werden.
Bei wenigen Datensätzen würde sich dieser Aufbau sicherlich anbieten, nicht aber bei sehr vielen. Angenommen man hätte sehr viele Gruppenmitglieder eingegeben, würde die Angabe des Attributs mit dem dem Wert "teilnehmer" redundant werden, da das Attribut nur für die Trennung des Leiters von den restlichen Personen eingeführt wurde.
In der ersten Variante wird dieses Problem gelöst, indem man den Kontext mitberücksichtigt, in welchen sich ein Element befindet.
Generell wurde zudem darauf verzichtet den Personendatensätzen eindeutige IDs zu vergeben. IDs sollten idealerweise nicht von Clienten sondern nur von dem empfangenden Server vergeben werden.


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

Für die Abbildung der Daten auf ein JSON-Dokument, wurde sich an das zuvor erstellte XML-Dokument und seiner Struktur orientiert.
Auch hier wird der Gruppenleiter von allen weiteren Personen durch den Kontext, in welchem sie sich das Element befindet, getrennt.
Erwähnenswert ist zudem die Entscheidung die Personendatensätze in einem normalen Array aufzulisten. Somit wird die Reihenfolge in welcher die Personen eingetragen wurden beibehalten, was für die weitere Verwertung der Daten evtl. relevant sein könnte.
Hätte man die Datensätze in einem Objekt (Dictionary) gekapselt, hätte man somit keine wirkliche Reihenfolge mehr.


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

Es wurde sich dafür entschieden die Grafiken über die Angabe einer URI anzugeben. Somit muss es einen Server geben, der diese Grafiken über die angegebene URI ausliefert.
Es besteht aber auch zusätzlich die Möglichkeit Grafiken direkt in das XML-Dokument einzubetten. Dazu muss die Grafik die als Binärdatei vorliegt vor in eine Zeichenfolge überführt werden, um sie erfolgreich in das Dokument einbetten zu können. Der Empfänger muss die Zeichenfolge dann nur noch zurück in eine Binärdatei umwandeln.
Sehr beliebt ist dafür das Base64-Verfahren. Dennoch, mit dem Vorteil Grafiken in XML-Dokumenten einbetten zu können, kommt gleichzeitig auch der Nachteil, dass Dokumente dadurch aufgebläht werden. Es müssen so viel mehr Daten transportiert werden. In Fällen wo eine effiziente und schnelle Übertragung der Daten eine wichtige Voraussetzung ist, fällt das Einbetten von ganzen Grafiken negativ ins Gewicht.



**d)**

siehe  - [misc/aufgabe3d.xsd](https://github.com/jhfpereira/wba2_sose13_phase1/blob/master/Phase1/misc/aufgabe3d.xsd "XML Schema Definition") -
	u. - [misc/aufgabe3d.xsd](https://github.com/jhfpereira/wba2_sose13_phase1/blob/master/Phase1/misc/aufgabe3d.xml "XML Dokument - Rezepte") -



###Aufgabe 4

**a)**
Anhand des XML-Schemas wurde eine Klasse "RezeptType" generiert.
Hätte man die verschiedenen verschachtelten complex-types ausgelagert und mit einem Namen referenziert, hätte "xjc" mehrere Klassen generiert, nämlich für jeden complex-type eine.
Das hat er in diesem Fall nicht getan, da sich die complex-types verschachtelt im Oberdatentyp "rezeptType" befinden. Somit sind diese Klassen als statische verschachtelte Klassen (static nested classes) der "RezeptType"-Klasse zu finden.
Der Vorteil an dieser herangehensweise bzw. der Strukturierungsart des XML-Schemas liegt darin, dass nur eine Klasse generiert wird (die Klasse "ObjectFactory" nicht mitgezählt) und somit ein sauberer und übersichtlicher src-Tree gegeben ist.
Für diese Vorgehensweise gibt es aber auch ein Nachteil. Das XML-Schema ist im Nachhinein schwieriger zu pflegen bzw. zu erweitern. Man sollte also schon vor der Datenmodulierung abschätzen, welche Strukturierungsart sich im gegebenen Fall eher anbietet.
Man sollte zudem darauf achten, dass nicht beide Strukturierungsarten gemischt angewandt werden, sofern nicht anders möglich.



**b)**

siehe - [src/RezeptMain.java](https://github.com/jhfpereira/wba2_sose13_phase1/blob/master/Phase1/src/de/fhkoeln/gm/wba2/phase1/RezepteMain.java "RezeptMain.java") -


**c)**

siehe - [src/RezeptMain.java](https://github.com/jhfpereira/wba2_sose13_phase1/blob/master/Phase1/src/de/fhkoeln/gm/wba2/phase1/RezepteMain.java "RezeptMain.java") -



###Aufgabe 5

Der Vorteil Daten in Formaten wie XML und JSON zu speichern liegt darin, dass sie leichter von Maschinen gelesen und weiterverarbeitet werden können.
Durch die fest vorgschriebene Struktur und Aufbau eines solchen Formats, kann auch eine leichtere Umwandlung in ein anderes Format ermöglicht werden.
Relevante Daten können so zudem auch schneller im Dokument lokalisiert und ggf. für die Weiterverarbeitung extrahiert werden, da sie einer einheitlichen Struktur folgen.
Sicherlich ist die Möglichkeit XML-Dokumente mittels einer entsprechenden Transformationssprache wie z.B XSLT in ein anderes Dokument zu transformieren, ein weiterer Vorteil von XML.

Im Vergleich zu JSON besitzen XML-Dokumente einen sehr hohen Overhead, was sich für Datenübertragungen negativ auswirken kann. Obwohl beide Formate vom Mensch gelesen werden können, ist das XML-Format, durch die Verwendung von Tags mit verdeutlichenden Namen, etwas leserlicher.
Über den Tagnamen ist für einen Menschen klarer, was ein Wert verdeutlichen soll. Das XML-Format ist im Vergleich zu JSON zudem flexibler (Attribute, Kommentare, Verarbeitungsanweisungen). JSON folgt da mehr dem Key-Value-Prinzip, wobei aus der Angabe des Werts auch direkt sein Typ ersichtlich ist, da JSON nur eine kleine Auswahl an elementaren Datentypen vorsieht.  
Durch diese Begrenzung auf feste elementare Datentypen ist JSON, im Gegensatz zu XML, weniger komplex. Dies ermöglicht ein besseres Handhaben der Daten, aber viel wichtiger noch, das schnellere und leichtgewichtigere Parsen eines JSON-Dokuments bzw. der Abbildung der Daten auf native Datentypen und Datenstrukturen einer Programmier- oder Interpretersprache (als Beispiel seien assoziative und numerische Arrays genannt).  
Im Bereich der Webentwicklung ist ein Trend erkennbar, in dem weniger auf XML, dafür verstärkt auf JSON gesetzt wird. Dies ist mit dem durch XML angelasteten Nachteil des immensen Datenoverhead zu begründen. JSON ist simpler, kompakter in der Strukturierungsweise, somit kleiner in der Datengröße und bietet sich dadurch für APIs geradezu bestens an.
XML verwendet man speziell in Fällen, wo es besserer Datenkontrolle bedarf.
