import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    private static boolean checkIfVisible(int[][] visibleTrees, int i, int j){
        boolean isVisible = true;
        for(int k = 0; k < i; k++){
            if(visibleTrees[k][j] == 0){
                isVisible = false;
                break;
            }
        }
        for(int k = visibleTrees.length-1; k > i; k--){
            if(visibleTrees[k][j] == 0){
                isVisible = false;
                break;
            }
            isVisible = true;
        }

        for(int k = 0; k < j; k++){
            if(visibleTrees[i][k] == 0){
                isVisible = false;
                break;
            }
            isVisible = true;
        }

        for(int k = visibleTrees[i].length-1; k > j; k--){
            if(visibleTrees[i][k] == 0){
                isVisible = false;
                break;
            }
            isVisible = true;
        }
        return isVisible;
    }

    public static int solvePuzzle(int puzzlePart) throws IOException{
        List<String> input = createList(Path.of("Input.txt"));
        int[][] trees = new int[input.size()][input.get(0).length()];
        int[][] locationVisibleTrees = new int[trees.length][trees[0].length];
        for (int j = 0; j < input.size(); j++) {
            for (int i = 0; i < input.get(0).length(); i++){
                trees[j][i] = input.get(j).charAt(i)-48;
            }
        }

        for (int i = 1; i < locationVisibleTrees.length-1; i++){
            for (int j = 0; j < locationVisibleTrees[i].length; j+=98){
                locationVisibleTrees[i][j] = 1;
            }
        }
        for (int i = 0; i < locationVisibleTrees.length; i+= 98){
            Arrays.fill(locationVisibleTrees[i], 1);
        }
        int visibleTrees = 99+97+99+97;
        if(puzzlePart == 1){
            for(int i = 1; i < 98; i++){
                for (int j = 1; j < 98; j++){
                    if((trees[i-1][j] < trees[i][j] || trees[i+1][j] < trees[i][j] || trees[i][j+1] < trees[i][j] || trees[i][j-1] < trees[i][j])
                        && checkIfVisible(locationVisibleTrees, i, j)) {

                        locationVisibleTrees[i][j] = 1;
                    }
                }
            }
            for (int[] i: locationVisibleTrees) {
                for (int j: i) {
                    if (j == 1){
                        visibleTrees++;
                    }
                }
            }
            return visibleTrees;
        }
        else {
            return -1;
        }
    }
}
