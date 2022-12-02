import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strategy = Files.readAllLines(Path.of("RPS.txt"));
        var sum = 0;
        for (String s : strategy){
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
        System.out.println(sum);
    }
}
