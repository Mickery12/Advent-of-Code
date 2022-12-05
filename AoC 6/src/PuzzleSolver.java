import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {
    
    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(Path.of(path.toUri()));
    }
    
    public static String solvePuzzle(){
        return "yeet";
    }
}
