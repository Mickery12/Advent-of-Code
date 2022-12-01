/**
 * Stellt ein Datum-Goldpreis-Paar dar.
 *
 * @author Samuel Thesing, Jonas Feldbruegge, Michael Conrads
 */
public class Goldtagespreis {

    private final String datum;
    private final double preis;

    /**
     * Erstellt ein Goldtagespreis-Objekt
     *
     * @param datum das Datum
     * @param preis der zugehoerige Goldpreis
     */
    public Goldtagespreis(String datum, double preis) {
        this.datum = datum;
        this.preis = preis;
    }

    /**
     * Gibt das Datum zurueck
     *
     * @return das Datum
     */
    public String getDatum() {
        return this.datum;
    }

    /**
     * Gibt den Preis zurueck
     *
     * @return der Preis
     */
    public double getPreis() {
        return this.preis;
    }

    /**
     * Gibt eine String-Darstellung des Datum-Goldpreispaares zurueck<br>
     * <b>Format:</b> {Datum}\t{Goldpreis}
     *
     * @return String-Darstellung
     */
    public String toString() {
        return "" + datum + '\t' + preis;
    }

}
