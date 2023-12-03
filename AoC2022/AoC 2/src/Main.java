import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try
        {
            System.out.println(Strategy.getPointsFromStrategy1());
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Strategy.getPointsFromStrategy2());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
