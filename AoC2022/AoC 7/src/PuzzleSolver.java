import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleSolver {

    private static List<String> createList(Path path) throws IOException {
        return Files.readAllLines(path);
    }
    
    private static void createTree(Node currentDir, List<String> commands){
        for (String s: commands) {
            if(s.equals("$ cd /")){
                continue;
            }
            if(s.equals("$ cd ..")){
                currentDir = currentDir.getParent();
            }
            else if(s.startsWith("$ cd")){
                currentDir = currentDir.getNodeDir(s.substring(5));
            }
            if (!s.startsWith("$")) {
                if (s.startsWith("dir")) {
                    currentDir.addtoDir(s.substring(4));
                } else {
                    String[] temp = s.split(" ");
                    currentDir.addToFiles(temp[1], Integer.parseInt(temp[0]));
                }
            }
        }
    }
    
    public static int determineSizeSum(Node rootNode){
        
        int sum = 0;
        for (int i = 0; i < rootNode.getNodeDirSize(); i++){
            Node currentNode = rootNode.getNodeDir(i);
            if(currentNode.getNodeDirSize() != 0){
                   sum += determineSizeSum(currentNode);
            }
            if(currentNode.getSize() < 100000){
                sum += currentNode.getSize();
            }
        }
        
        return sum;
    }
    
    public static int sizeOfSmallestDirectoryNeeded(Node rootNode, int rootSize){
        int needed = rootSize - 40000000;
        int min = rootNode.getSize();
        if (min < needed) {
            return Integer.MAX_VALUE;
        }
        for (int i = 0; i < rootNode.getNodeDirSize(); i++){
            Node currentNode = rootNode.getNodeDir(i);
            min = Math.min(sizeOfSmallestDirectoryNeeded(currentNode, rootSize), min);
        }
        return min;
    }

    public static int solvePuzzle(int puzzlePart) throws IOException {
        List<String> commands = createList(Path.of("Directories.txt"));
        Node rootNode = new Node("/", 0, null);
        createTree(rootNode, commands);
        return puzzlePart == 1 ? determineSizeSum(rootNode) : sizeOfSmallestDirectoryNeeded(rootNode, rootNode.getSize());
    }
}
