import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> calories =  Files.readAllLines(Path.of("Calories.txt"));
        int max = 0;
        int sum = 0;
        ArrayList<Integer> caloriesPerElve = new ArrayList<>();
        for (String s: calories){
            
            if (Objects.equals(s, "")) {
                caloriesPerElve.add(sum);
                sum = 0;
                
            } else{
                sum += Integer.parseInt(s);
            }
        }
        caloriesPerElve.sort(Integer::compareTo);
        max = caloriesPerElve.get(caloriesPerElve.size()-1) +caloriesPerElve.get(caloriesPerElve.size()-2) +caloriesPerElve.get(caloriesPerElve.size()-3);
                  System.out.println(max);
    }
}