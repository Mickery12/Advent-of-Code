import java.io.IOException;

public class Main {
    
    
    public static void main(String[] arg) {
        try {
            System.out.println(CrateMover.outputAfterMovingCrates(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            System.out.println(CrateMover.outputAfterMovingCrates(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}