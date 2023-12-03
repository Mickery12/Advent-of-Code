import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    private static boolean checkIfVisible(int[][] trees, int i, int j){
        boolean isVisible = true;
        for(int k = 0; k < i; k++){
            if(trees[k][j] >= trees[i][j]){
                isVisible = false;
                break;
            }
        }
        if(isVisible){
            return true;
        }
        isVisible = true;
        for(int k = trees.length-1; k > i; k--){
            if(trees[k][j] >= trees[i][j]){
                isVisible = false;
                break;
            }
            
        }
        if(isVisible){
            return true;
        }
        isVisible = true;
        for(int k = 0; k < j; k++){
            if(trees[i][k] >= trees[i][j]){
                isVisible = false;
                break;
            }
        }
        if(isVisible){
            return true;
        }
        isVisible = true;
        for(int k = trees[i].length-1; k > j; k--){
            if(trees[i][k] >= trees[i][j]){
                isVisible = false;
                break;
            }
        }
        return isVisible;
    }
    
    private static int countVisibleRange(int[][] trees, int i, int j){
        int visibleRangeYP = 0;
        int visibleRangeXP = 0;
        int visibleRangeYN = 0;
        int visibleRangeXN = 0;
    
        int offset = 1;
        
        if(i == 0 || j == 0 || i == trees.length-1 || j == trees[i].length-1){
            return 0;
        }
        
        for(int k = i-1; k >= 0; k--, offset++){
            
            if(trees[k][j] >= trees[i][j]){
                visibleRangeYP = offset;
                break;
            }
            else if(k==0){
                visibleRangeYP = offset;
            }
        }
        offset = 1;
        for(int k = i+1; k < trees.length; k++, offset++){
            if(trees[k][j] >= trees[i][j]){
                visibleRangeYN = offset;
                break;
            }
            else if(k==trees.length-1){
                visibleRangeYN = offset;
            }
        }
        offset = 1;
        for(int k = j-1; k >= 0; k--, offset++){
            if(trees[i][k] >= trees[i][j]){
                visibleRangeXP = offset;
                break;
            }
            else if(k==0){
                visibleRangeXP = offset;
            }
        }
    
        offset = 1;
        
        for(int k = j+1; k < trees[i].length; k++, offset++){
            if(trees[i][k] >= trees[i][j]){
                visibleRangeXN = offset;
                break;
            }
            else if(k==trees[i].length-1){
                visibleRangeXN = offset;
            }
        }
        return (visibleRangeXN*visibleRangeXP*visibleRangeYN*visibleRangeYP);
    }

    public static int solvePuzzle(int puzzlePart) throws IOException{
        List<String> input = createList(Path.of("Input.txt"));
        int[][] trees = new int[input.size()][input.get(0).length()];
        for (int j = 0; j < input.size(); j++) {
            for (int i = 0; i < input.get(0).length(); i++){
                trees[j][i] = input.get(j).charAt(i)-48;
            }
        }

        if(puzzlePart == 1) {
            int visibleTrees = 99+97+99+97;
            for (int i = 1; i < trees.length-1; i++) {
                for (int j = 1; j < trees[i].length-1; j++) {
                    if(checkIfVisible(trees, i, j)){
                        visibleTrees++;
                    }
                }
            }
            return visibleTrees;
        }
        else {
            var visibleRange = 0;
            for (int i = 0; i < trees.length; i++) {
                for (int j = 0; j < trees[i].length; j++){
                    visibleRange = Math.max(countVisibleRange(trees, i, j), visibleRange);
                }
            }
            return visibleRange;
        }
    }
}
