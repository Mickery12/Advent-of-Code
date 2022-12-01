import java.util.Arrays;

public class TestRechenoperationsliste {

    public static void main (String[] args){
        double[] ausgangsfeld = { 1, 3, 5, 6 };
        Rechenoperationsliste r = new Rechenoperationsliste();
        // Berechnet die Funktion (x^2)+2
        r.add(new Quadrat());
        r.add(new Addition(2));
        // Berechnung und Ausgabe
        double[] test1 = r.transform(ausgangsfeld);
        // ergibt {3,11,27,38}
        System.out.println(Arrays.toString(test1));
        // fuegt der Rechenoperationsliste eine weitere Rechenoperation hinzu
        // und berechnet daher insgesamt Math.sqrt((x^2)+2)
        r.add(new Quadratwurzel());
        // Berechnung und Ausgabe
        double[] test2 = r.transform(ausgangsfeld);
        // ergibt { 1.7320508075688772,
        // 3.3166247903554,
        // 5.196152422706632,
        // 6.164414002968976}
        System.out.println(Arrays.toString(test2));
    }
}
