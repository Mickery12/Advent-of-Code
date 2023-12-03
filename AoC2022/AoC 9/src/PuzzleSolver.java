import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    private static int calculateAllPositionsVisited(Point[] tails){
        return tails[9].getPositionsVisited().size();
    }
  
    public static int solvePuzzle(int puzzlePart) throws IOException {
        List<String> input = createList(Path.of("Input.txt"));
        var head = new Point(0, 0);
        Point[] tails = {new Point(head), new Point(head), new Point(head), new Point(head), new Point(head), new Point(head), new Point(head), new Point(head), new Point(head), new Point(head)};
        
        if(puzzlePart == 1){
            for (String s: input){
                char[] ca = s.toCharArray();
                tails[0].calculatePostionHead(ca[0], Integer.parseInt(s.substring(2)), tails[0], tails[1], 1, tails);
            }
            return tails[1].positionsVisitedTotal();
        }

        else {
            for (String s: input){
                char[] ca = s.toCharArray();
                tails[0].calculatePostionHead(ca[0], Integer.parseInt(s.substring(2)), tails[0], tails[1], 2, tails);
            }
            return calculateAllPositionsVisited(tails);
        }
    }
}
