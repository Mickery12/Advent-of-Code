import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Strategy {

    private static List<String> getStrategy() throws IOException {
        return Files.readAllLines(Path.of("RPS.txt"));
    }
    public static int getPointsFromStrategy1() throws IOException {
        List<String> strategy = getStrategy();
        int sum = 0;
        for ( String s: strategy) {
            switch (s) {
                case "A X" -> sum += 4;
                case "A Y" -> sum += 8;
                case "A Z" -> sum += 3;
                case "B X" -> sum += 1;
                case "B Y" -> sum += 5;
                case "B Z" -> sum += 9;
                case "C X" -> sum += 7;
                case "C Y" -> sum += 2;
                case "C Z" -> sum += 6;
            }
        }
        return sum;
    }

    public static int getPointsFromStrategy2() throws IOException {
        int sum = 0;
        List<String> strategy = getStrategy();
        for (String s : strategy) {
            switch (s) {
                case "A X" -> sum += 3;
                case "A Y" -> sum += 4;
                case "A Z" -> sum += 8;
                case "B X" -> sum += 1;
                case "B Y" -> sum += 5;
                case "B Z" -> sum += 9;
                case "C X" -> sum += 2;
                case "C Y" -> sum += 6;
                case "C Z" -> sum += 7;
            }
        }
        return sum;
    }
}
