/**
 * Die Klasse stellt eine komplexe Zahl der Form a + bi dar,
 * wobei a der Realteil und bi der Imaginaerteil der Zahl ist.
 **/
public class Komplex {

    private double real;
    private double imaginaer;

    /**
     * Konstruktor der Klasse Komplex
     * @param real Wert fuer den Realteil der komplexen Zahl.
     * @param imaginaer Wert fuer den Imaginaerteil der komplexen Zahl.
     **/
    public Komplex(double real, double imaginaer){
        this.real = real;
        this.imaginaer = imaginaer;
    }

    /**
     * Gibt den Imaginaerwert zurueck.
     * @return Imaginaerwert
     **/
    public double getImaginaer() {
        return imaginaer;
    }

    /**
     * Gibt den Realwert zurueck.
     * @return Realwert
     **/
    public double getReal() {
        return real;
    }

    /**
     * Addiert die Realwerte und die Imaginaerwerte dieser und einer weiteren komplexen Zahl.
     * @param z komplexe Zahl
     **/
    public void addiere(Komplex z){
        this.real += z.real;
        this.imaginaer += z.imaginaer;
    }

    /**
     * Multipliziert diese komplexe Zahl mit einer weiteren komplexen Zahl.
     * @param z komplexe Zahl
     **/
    public void multipliziere(Komplex z){
        double realMult = (this.real*z.real) - (this.imaginaer*z.imaginaer);
        double imaginaerMult = (this.real*z.imaginaer) + (this.imaginaer*z.real);
        this.real = realMult;
        this.imaginaer = imaginaerMult;
    }

    /**
     * Gibt den Betrag der komplexen Zahl zurueck.
     * @return Betrag der komplexen Zahl.
     **/
    public double getBetrag(){
        return Math.sqrt(Math.pow(this.real, 2)+Math.pow(this.imaginaer, 2));
    }

    /**
     * Drueckt die komplexe Zahl als String aus.
     * @return Die komplexe Zahl als String.
     **/
    @Override
    public String toString() {
        if(imaginaer == -1){
            return real+" - i";
        }
        if(imaginaer < 0) {
            return real + " - " + Math.abs(imaginaer) + "i";
        }
        if(imaginaer == 1.0){
            return real+" + i";
        }
        if(imaginaer == 0){
            return real+"";
        }
        return real +" + "+ imaginaer + "i";
    }

    /**
     * Berechnet die Quadratwurzeln dieser komplexen Zahl mithilfe der Formel von Moivre und packt diese in ein Array. Falls
     * der Realteil und der Imaginaerteil der komplexen Zahl 0 sind, wird das Array mit zwei 0-Feldern gefuellt.
     * @return Das Array mit den Quadratwurzeln.
     **/
    public Komplex[] getWurzel() {
        Komplex[] wurzel = {new Komplex(0, 0), new Komplex(0, 0)};
        if (this.real == 0 && this.imaginaer == 0) {
            return wurzel;
        }
        double phi = Math.atan2(imaginaer, real);
        double wurzelRadius = Math.sqrt(this.getBetrag());
        wurzel[0] = new Komplex(wurzelRadius * Math.cos(phi / 2.), wurzelRadius * Math.sin(phi / 2.));
        wurzel[1] = new Komplex(wurzelRadius * Math.cos((phi+2*Math.PI)/ 2.), wurzelRadius * Math.sin((phi+2*Math.PI) / 2.));
        return wurzel;    }

    /**
     * Addiert die Realwerte und die Imaginaerwerte dieser und einer weiteren komplexen Zahl und gibt das Ergebnis
     * als komplexe Zahl zurueck.
     * @param z  komplexe Zahl
     * @return  Ergebnis der Addition
     **/
    public Komplex getSumme(Komplex z){
        double realSum = this.real+z.real;
        double imaginaerSum = this.imaginaer+z.imaginaer;
        return new Komplex(realSum, imaginaerSum);
    }

    /**
     * Multipliziert diese komplexe Zahl mit einer weiteren komplexen Zahl und gibt das Ergebnis als komplexe
     * Zahl zurueck.
     * @param z  komplexe Zahl
     * @return Ergebnis der Multiplikation
     **/
    public Komplex getProdukt(Komplex z){
        double realMult = (this.real*z.real) - (this.imaginaer*z.imaginaer);
        double imaginaerMult = (this.real*z.imaginaer) + (this.imaginaer*z.real);
        return new Komplex(realMult, imaginaerMult);
    }
}
