import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    private static int determineLength(int puzzlePart){
        return puzzlePart == 1 ? 4 : 14;
    }
    private static boolean searchInArray(char[] chars){
        for (int j = 0; j < chars.length; j++) {
            for(int k = j+1; k < chars.length; k++){
                if(chars[k] == chars[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int solvePuzzle(int puzzlePart) throws IOException {
        var input = createList(Path.of("Input.txt"));

        var sb = new StringBuilder(input.get(0));

        char[] chars = new char[determineLength(puzzlePart)];

        for (var i = 0; i < sb.length(); i++) {
            chars[(i % chars.length)] = sb.charAt(i);
            if(i > chars.length){
                if(searchInArray(chars)){
                    continue;
                }
                return i+1;
            }
        }
        return 0;
    }
}
