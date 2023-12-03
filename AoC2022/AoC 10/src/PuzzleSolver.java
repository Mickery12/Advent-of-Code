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
        
        
        if(puzzlePart == 1){
            int cycle = 0;
            int signal = 0;
            int totalSignalStrength = 0;
            for (String s : input){
                if((cycle + 20) % 40 == 0){
                    totalSignalStrength += (cycle*signal);
                }
                if(s.equals("noop")){
                    cycle++;
                    if((cycle + 20) % 40 == 0){
                        totalSignalStrength += (cycle*signal);
                    }
                }
                else {
                    cycle++;
                    if((cycle + 20) % 40 == 0){
                        totalSignalStrength += (cycle*signal);
                    }
                    cycle++;
                    signal += Integer.parseInt(s.substring(5));
                }
            }
            return totalSignalStrength;
        }
        
        else {
            return -1;
        }
    }
}
