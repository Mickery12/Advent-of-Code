public class Addition implements Rechenoperation{
    private double zahl;

    public Addition (double pZahl){
        zahl = pZahl;
    }

    public double berechne (double x) {
        x += zahl;
        return x;
    }
}
