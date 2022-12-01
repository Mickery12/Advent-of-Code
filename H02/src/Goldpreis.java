import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Verarbeitet eine Datei von Datum-Goldpreis-Paaren.
 *
 * @author Samuel Thesing, Jonas Feldbruegge, Michael Conrads
 */
public class Goldpreis {

    private ArrayList<Goldtagespreis> list = new ArrayList<>();

    /**
     * Liest Datum-Goldpreis-Paare aus Datei ein.<br>
     * <b>Erwartetes Format:</b> {Datum}\t{Goldpreis}<br>
     * Preis im deutschen Zahlenformat
     * Bei einer inkorrekt formatierten Zeile, wird diese uebersprungen und eine Meldung in der Konsole ausgegeben.
     *
     * @param dateiname Pfad der einzulesenden Datei
     * @throws FileNotFoundException Datei konnte nicht gefunden werden
     * @throws ParseException Preis konnte nicht eingelesen werden
     */
    public Goldpreis(String dateiname) throws FileNotFoundException, ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);

        Scanner sc = new Scanner(new File(dateiname));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splited = line.split("\t");
            try {
                if (splited[1].equals("kein Nachweis")) {
                    list.add(new Goldtagespreis(splited[0], -1.0));
                } else {
                    Number preis = format.parse(splited[1]);
                    list.add(new Goldtagespreis(splited[0], preis.doubleValue()));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Failed to parse line ('"+line+"')");
            }
        }
        sc.close();
    }

    /**
     * Gibt den Goldpreis vom angegebenen Datum zurueck.<br>
     * Wochenendtage geben -1 zurueck.
     *
     * @param datum das Datum
     * @return Goldpreis am angegebenen Datum
     * @throws NumberFormatException das Datum existiert nicht in der eingelesenen Liste
     */
    public double getPreis(String datum) throws NumberFormatException {
        for (Goldtagespreis tagespreis : this.list) {
            if (tagespreis.getDatum().equals(datum)) {
                return tagespreis.getPreis();
            }
        }
        throw new NumberFormatException("Datum nicht vorhanden");
    }

    /**
     * Gibt den maximalen so wie den minimalen Goldpreis und alle Tage, an denen diese erreicht wurden, aus.
     */
    public void printMinMax() {
        double minPreis = Double.MAX_VALUE;
        double maxPreis = -1.0;
        for (Goldtagespreis tagespreis : this.list) {
            if (tagespreis.getPreis() != -1.0) {
                minPreis = Math.min(minPreis, tagespreis.getPreis());
            }
            maxPreis = Math.max(maxPreis, tagespreis.getPreis());
        }

        if (minPreis != Double.MAX_VALUE) {
            System.out.println("Den niedrigsten Goldpreis von " + minPreis + " gab es an folgenden Tagen:");
            for (Goldtagespreis tagespreis : this.list) {
                if (tagespreis.getPreis() == minPreis) {
                    System.out.println(tagespreis.getDatum());
                }
            }
        }

        if (maxPreis != -1.0) {
            System.out.println("Den hoechsten Goldpreis von " + maxPreis + " gab es an folgenden Tagen:");
            for (Goldtagespreis tagespreis : this.list) {
                if (tagespreis.getPreis() == maxPreis) {
                    System.out.println(tagespreis.getDatum());
                }
            }
        }
    }

}
