import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static int solvePuzzle(int puzzlePart) throws IOException {
        List<String> commands = createList(Path.of("Directories.txt"));
        ArrayList<Object> directories = new ArrayList<Object>();
        int n = 0;
        for (int i = 0; i < commands.size(); i++){
            if(commands.get(i).startsWith("$ cd")){
                directories.add(new ArrayList<Object>());
                directories.get(n).add(commands.get(i).substring(4));
            }
        }
    }
}
