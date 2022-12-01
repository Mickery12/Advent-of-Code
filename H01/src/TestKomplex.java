import java.util.Arrays;

public class TestKomplex{
    public static void main (String[] args){
        Komplex z = new Komplex(0,0); // z := 0
        System.out.println("z = " + z);
        z = new Komplex(1,0); // z := 1
        System.out.println("z = " + z);
        z = new Komplex(0,1); // z := i
        System.out.println("z = " + z);
        z = new Komplex(-4,0); // z := -4
        System.out.println("z = " + z);
        Komplex[] wurzeln = z.getWurzel(); // => 2i und -2i
        System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
        z = new Komplex(1,1); // z := 1+i
        System.out.println("z = " + z);
        double betrag = z.getBetrag();
        System.out.println("|z| = " + betrag); // => sqrt(2) = 1.41...
        Komplex z2 = new Komplex(2,1); // z2 := 2+i
        System.out.println("z2 = " + z2);
        z.addiere(z2);
        System.out.println("z nach Addition von z2 = " + z);
        z.multipliziere(z2);
        System.out.println("z nach Multiplikation von z2 = " + z);
        z2 = z.getProdukt(new Komplex(-1,0)); // z2 := -z
        System.out.println("z2 = " + z2);
        Komplex summe = z.getSumme(z2); // z := z - z2 = 0
        System.out.println("summe = " + summe);
        }
}