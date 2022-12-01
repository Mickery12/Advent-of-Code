import java.io.FileNotFoundException;
import java.text.ParseException;

public class GoldpreisTest {

    public static void main(String[] args) {
        try {
            Goldpreis test = new Goldpreis("gold.txt");
            System.out.println(test.getPreis("2009-10-20"));
            System.out.println(test.getPreis("2009-02-07"));
            test.printMinMax();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        } catch (ParseException e) {
            System.out.println("Fehler beim Parsen eines Preises");
        } catch (NumberFormatException e) {
            System.out.println("Datum nicht gefunden");
        }
    }

}
