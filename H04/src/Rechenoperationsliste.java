import java.util.ArrayList;
import java.util.List;


public class Rechenoperationsliste{
    private ArrayList<Rechenoperation> rechenoperationsliste;

    /*
    * Konstruktor der Klasse Rechenoperationsliste.
     */
    public Rechenoperationsliste(){
        rechenoperationsliste  = new ArrayList<Rechenoperation>();
    }
    /* fuegt zur Liste der Rechenoperationen die uebergebene Operation hinzu.
    *
    */
    public void add(Rechenoperation rechenoperation){
        rechenoperationsliste.add(rechenoperation);
    }

    public double[] transform(double[] feld){
        for (int i = 0; i < feld.length; i++){
            for (int j = 0; j < rechenoperationsliste.size(); j++){
                rechenoperationsliste.get(j).berechne(feld[i]);
            }
        }
        return feld;
    }
}
