package de.fhkoeln.gm.wba2.phase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;

import java.util.Scanner;

import de.fhkoeln.gm.wba2.phase1.xml.jaxb.*;


public class RezepteMain {
    
    
    private static final String DEFAULT_XML = "./misc/aufgabe3d.xml";     
    private static Scanner in;
    
    
    public static void listeRezeptnamen(ArrayList<RezepteType.Rezept> list) {
        int count = 1;
        
        System.out.println();
        System.out.println("=== Rezepte ===");
        System.out.println();
        
        for (RezepteType.Rezept rezept : list) {
              System.out.println((count++) + ". " + rezept.getRezeptname());
        }
    }
    
    
    public static void listeRezept(RezepteType.Rezept rezept) {
        
        System.out.println();
        System.out.println(rezept.getRezeptname());
        System.out.println("------------------------");
        System.out.println();
        
        
        ArrayList<RezepteType.Rezept.Fotos.Foto> fotos = (ArrayList<RezepteType.Rezept.Fotos.Foto>) rezept.getFotos().getFoto();
        
        System.out.println("Fotos:");
        if(!fotos.isEmpty()) {
        	for(RezepteType.Rezept.Fotos.Foto foto: fotos) {
        		System.out.println("\t" + foto.getBenutzername() + " | " + foto.getAdresse());
        	}
        }
        else {
        	System.out.println("\t-- Keine Fotos --");
        }
        System.out.println();
        
        
        if(rezept.getArbeitszeit() != null) {
            System.out.print("Arbeitszeit: ");
            System.out.println("ca. " + rezept.getArbeitszeit() + " min");
        }
        
        if(rezept.getKochbackzeit() != null) {
            System.out.print("Koch-Back-zeit: ");
            System.out.println(rezept.getKochbackzeit());
        }

        if(rezept.getRuhezeit() != null) {
            System.out.print("Ruhezeit: ");
            System.out.println(rezept.getRuhezeit());
        }
        
        System.out.print("Schwierigkeit: ");
        System.out.println(rezept.getSchwierigkeitsgrad());
        
        if(rezept.getBrennwert() != null) {
            System.out.print("Brennwert p. P.: ");
            System.out.println(rezept.getBrennwert() + "kcal");
        }
        
        System.out.print("Portionen: ");
        System.out.println(rezept.getPortionen());
        
        System.out.println();
        System.out.println("Zutaten: ");
        ArrayList<RezepteType.Rezept.Zutaten.Zutat> zutatenlist = (ArrayList<RezepteType.Rezept.Zutaten.Zutat>) rezept.getZutaten().getZutat();
        for(RezepteType.Rezept.Zutaten.Zutat zutat: zutatenlist) {
            BigDecimal menge = zutat.getMenge();
            String einheit = zutat.getEinheit();
            String name = zutat.getName();
            
            String menge_str = (menge != null) ? menge.toString(): "    ";
            String einheit_str = (einheit != null) ? einheit: "    ";
            
            System.out.println("\t " + menge_str + "\t" + einheit_str + "\t| " + name);
        }
        
        System.out.println();
        System.out.println("Zubereitung:");
        System.out.println(rezept.getZubereitung());
        
        System.out.println();
        System.out.println();
        System.out.println("Kommentare:");
        ArrayList<RezepteType.Rezept.Kommentare.Kommentar> kommentare = (ArrayList<RezepteType.Rezept.Kommentare.Kommentar>) rezept.getKommentare().getKommentar();
        if(kommentare.isEmpty()) {
            System.out.println("\t-- keine Kommentare --");
        }
        else {
            for(RezepteType.Rezept.Kommentare.Kommentar kommentar: kommentare) {
                System.out.println("\tName:\t\t" + kommentar.getBenutzername());
                System.out.println("\tAvatar:\t\t" + kommentar.getAvatar());
                
                Date geschrieben_am = kommentar.getGeschriebenAm().toGregorianCalendar().getTime();
                
                System.out.println("\tGeschrieben am:\t" + new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(geschrieben_am));
                System.out.println("\tNachricht:\t" + kommentar.getNachricht());
                System.out.println();
            }
        }
    }
    
    
    public static void kommentiereRezept(ArrayList<RezepteType.Rezept.Kommentare.Kommentar> kommentarliste) {
        System.out.println();
        System.out.print("Name: ");
        String benutzername = in.next();
        in.nextLine();
        System.out.print("Nachricht: ");
        String nachricht = in.nextLine();

        RezepteType.Rezept.Kommentare.Kommentar kommi = new RezepteType.Rezept.Kommentare.Kommentar();
        kommi.setBenutzername(benutzername);

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());

        XMLGregorianCalendar currGregCal;
        try {
            currGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            kommi.setGeschriebenAm(currGregCal);
        } catch (DatatypeConfigurationException e) {}

        kommi.setNachricht(nachricht);

        kommentarliste.add(kommi);
    }
    
    
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        
        String filename = DEFAULT_XML;
        
        if(args.length == 1) {
            // Dateiname kann als erster Parameter mitgegeben werden
            filename = args[0];
        }
        

        in = new Scanner(System.in);
        

        JAXBContext context = JAXBContext.newInstance(RezepteType.class);

        Unmarshaller um = context.createUnmarshaller();
        RezepteType rezepte = (RezepteType) um.unmarshal(new StreamSource(new File(filename)), RezepteType.class).getValue();
        ArrayList<RezepteType.Rezept> list = (ArrayList<RezepteType.Rezept>) rezepte.getRezept();

        if(list.isEmpty()) {
            System.err.println("Keine Rezepte gefunden!");
            System.exit(1);
        }


        int auswahl = -1;

        do {
            System.out.println();
            System.out.println("=== Rezeptsammlung ===");
            System.out.println();
            System.out.println("1. Auflistung der Rezeptnamen");
            System.out.println("2. Auflistung eines Rezepts");
            System.out.println("3. Rezept kommentieren");
            System.out.println("4. Programm beenden");
            System.out.println();
            System.out.println("Ihre Auswahl: ");

            auswahl = in.nextInt();
    
            System.out.println();
    
            int rezeptauswahl = -1;
    
            switch(auswahl) {
                case 1:
                        listeRezeptnamen(list);
                    break;
                case 2:
                    do {
                        System.out.println("Geben sie bitte die Nummer des Rezepts an: ");
                        rezeptauswahl = in.nextInt();
            
                        if(rezeptauswahl <= 0 || rezeptauswahl > list.size()) {
                            System.err.println("Es gibt kein Rezept mit dieser Nummer!");
                            System.out.println();
                        }
                        else {
                            listeRezept(list.get(rezeptauswahl-1));
                        }
                    }
                    while(rezeptauswahl <= 0 || rezeptauswahl > list.size());
            
                    break;
                case 3:
            
                    do {
                        System.out.println("Geben sie bitte die Nummer des Rezepts an: ");
                        rezeptauswahl = in.nextInt();
            
                        if(rezeptauswahl <= 0 || rezeptauswahl > list.size()) {
                            System.err.println("Es gibt kein Rezept mit dieser Nummer!");
                            System.out.println();
                        }
                        else {
                            ArrayList<RezepteType.Rezept.Kommentare.Kommentar> kommentare = (ArrayList<RezepteType.Rezept.Kommentare.Kommentar>) list.get(rezeptauswahl-1).getKommentare().getKommentar();
                            kommentiereRezept(kommentare);
                    
                            // XML-Dokument mit aktuellen Daten (eingetragener Kommentar) schreiben
                            Marshaller m = context.createMarshaller();
                            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                            m.marshal(new ObjectFactory().createRezepte(rezepte), new File(filename));
                        }
                    }
                    while(rezeptauswahl <= 0 || rezeptauswahl > list.size());
            
                    break;
                default:
                    continue;
            }
    
        }
        while(auswahl != 4);
    }

}
