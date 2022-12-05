import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CrateMover {
    
    private static List<String> fillList(Path path) throws IOException {
        return Files.readAllLines(Path.of(path.toUri()));
    }
    
    private static void fillStacks(ArrayList<Stack<Character>> stacks, List<String> stackInput){
        int sizeOfStackInput = stackInput.size()-2;
        for(int i = sizeOfStackInput; i >= 0; i--){
            int k = 0;
            for(int j = 1; j < stackInput.get(i).length()-1; j += 4){
                if(stackInput.get(i).charAt(j) <= 'Z' && stackInput.get(i).charAt(j) >= 'A') {
                    stacks.get(k).add(stackInput.get(i).charAt(j));
                }
                k++;
            }
        }
    }
    
    public static StringBuilder outputAfterMovingCrates(int input) throws IOException {
        if (input < 0 || input > 2){
            throw new NumberFormatException("Es gibt nur 2 Art und Weisen wie man Crates verschieben kann, deshalb bitte entweder 1 oder 2 eingeben.");
        }
        List<String> stackInput = fillList(Path.of("StackInput.txt"));
        List<String> moveInput = fillList(Path.of("MoveInput.txt"));
        var stacks = new ArrayList<Stack<Character>>();
        
        for(int i = 0; i < 9; ++i) {
            stacks.add(new Stack<>());
        }
        
        fillStacks(stacks, stackInput);
        moveCrates(moveInput, stacks, input);
        StringBuilder sb = new StringBuilder();
        
        for(var s: stacks){
            sb.append(s.peek());
        }
        return sb;
    }
    
    private static void moveCrates(List<String> moveInput, ArrayList<Stack<Character>> stacks, int input) {
        for (String s: moveInput) {
            
            String[] eachWord = s.split(" ");
            int times = Integer.parseInt(eachWord[1]);
            int from = Integer.parseInt(eachWord[3])-1;
            int to = Integer.parseInt(eachWord[5])-1;
            Stack<Character> temp = new Stack<>();
            
            if(input == 1){
             
                for(int i = 0; i < times; i++){
                    stacks.get(to).push(stacks.get(from).pop());
                }
            }
            else if(input == 2) {
             
                for(int i = 0; i < times; i++){
                    temp.push(stacks.get(from).pop());
                }
                for(int i = 0; i < times; i++){
                    stacks.get(to).push(temp.pop());
                }
            }
        }
    }
}
