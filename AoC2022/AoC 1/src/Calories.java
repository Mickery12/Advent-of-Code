import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calories {
    private static List<String> getCalorieList() throws IOException {
        return Files.readAllLines(Path.of("Calories.txt"));
    }

    public static int calculateMaxCalories(int indexOfMaxSum) throws IOException {
        List<String> calories = getCalorieList();
        int max = 0;
        int sum = 0;
        ArrayList<Integer> caloriesPerElve = new ArrayList<>();
        for (String s: calories){
            if (Objects.equals(s, "")) {
                caloriesPerElve.add(sum);
                sum = 0;
            }
            else {
                sum += Integer.parseInt(s);
            }
        }
        caloriesPerElve.sort(Integer::compareTo);
        for (int i = 1; i < indexOfMaxSum+1; i++)
        {
            max += caloriesPerElve.get(caloriesPerElve.size()-i);
        }
        return max;
    }
}
