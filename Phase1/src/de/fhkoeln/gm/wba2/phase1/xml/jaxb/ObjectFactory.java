//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.10 um 08:20:17 PM GMT+01:00 
//


package de.fhkoeln.gm.wba2.phase1.xml.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Rezepte_QNAME = new QName("", "rezepte");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RezepteType }
     * 
     */
    public RezepteType createRezepteType() {
        return new RezepteType();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept }
     * 
     */
    public RezepteType.Rezept createRezepteTypeRezept() {
        return new RezepteType.Rezept();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Kommentare }
     * 
     */
    public RezepteType.Rezept.Kommentare createRezepteTypeRezeptKommentare() {
        return new RezepteType.Rezept.Kommentare();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Zutaten }
     * 
     */
    public RezepteType.Rezept.Zutaten createRezepteTypeRezeptZutaten() {
        return new RezepteType.Rezept.Zutaten();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Zutaten.Zutat }
     * 
     */
    public RezepteType.Rezept.Zutaten.Zutat createRezepteTypeRezeptZutatenZutat() {
        return new RezepteType.Rezept.Zutaten.Zutat();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Fotos }
     * 
     */
    public RezepteType.Rezept.Fotos createRezepteTypeRezeptFotos() {
        return new RezepteType.Rezept.Fotos();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Kommentare.Kommentar }
     * 
     */
    public RezepteType.Rezept.Kommentare.Kommentar createRezepteTypeRezeptKommentareKommentar() {
        return new RezepteType.Rezept.Kommentare.Kommentar();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Zutaten.Zutat.Menge }
     * 
     */
    public RezepteType.Rezept.Zutaten.Zutat.Menge createRezepteTypeRezeptZutatenZutatMenge() {
        return new RezepteType.Rezept.Zutaten.Zutat.Menge();
    }

    /**
     * Create an instance of {@link RezepteType.Rezept.Fotos.Foto }
     * 
     */
    public RezepteType.Rezept.Fotos.Foto createRezepteTypeRezeptFotosFoto() {
        return new RezepteType.Rezept.Fotos.Foto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RezepteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rezepte")
    public JAXBElement<RezepteType> createRezepte(RezepteType value) {
        return new JAXBElement<RezepteType>(_Rezepte_QNAME, RezepteType.class, null, value);
    }

}
