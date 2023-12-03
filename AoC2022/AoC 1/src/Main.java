import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            System.out.println(Calories.calculateMaxCalories(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            System.out.println(Calories.calculateMaxCalories(3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}