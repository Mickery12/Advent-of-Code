import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static String solvePuzzle(int puzzlePart) throws IOException{
        List<String> input = createList(Path.of("Input.txt"));
        if(puzzlePart == 1){
            return "nope";
        }
        else {
            return "yeet";
        }
    }
}
