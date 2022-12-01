public class Quadratwurzel implements Rechenoperation {


    public double berechne(double x) throws ArithmeticException{
        if (x >= 0) {
            return Math.sqrt(x);
        }
        throw new ArithmeticException("Eingegebene Zahl darf nicht negativ sein");
    }
}
