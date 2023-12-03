import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(Priorities.getSumItemPriorities());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            System.out.println(Priorities.getSumBadges());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
