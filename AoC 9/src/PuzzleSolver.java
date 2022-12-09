import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static int solvePuzzle(int puzzlePart) throws IOException {
        List<String> input = createList(Path.of("Input.txt"));
        var head = new Point(0, 0);
        var tail = new Point(head);
        for (String s: input){
            char[] ca = s.toCharArray();
            head.calculatePostionHead(ca[0], ca[2]-48, head, tail);
        }
        if(puzzlePart == 1){
            return tail.countPositionsVisitedAtLeastOnce();
        }

        else {
            return -1;
        }
    }
}
