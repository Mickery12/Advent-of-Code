import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

public class Main {


    public static void main(String[] arg) throws IOException {

        //char[] c = {'B', 'C', 'D', 'F', 'G', 'J', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Z'};
        List<String> moveInput = Files.readAllLines(Path.of("MoveInput.txt"));
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();
        Stack<Character> s4 = new Stack<>();
        Stack<Character> s5 = new Stack<>();
        Stack<Character> s6 = new Stack<>();
        Stack<Character> s7 = new Stack<>();
        Stack<Character> s8 = new Stack<>();
        Stack<Character> s9 = new Stack<>();
        s1.push('V');
        s1.push('C');
        s1.push('D');
        s1.push('R');
        s1.push('Z');
        s1.push('G');
        s1.push('B');
        s1.push('W');
        s2.push('G');
        s2.push('W');
        s2.push('F');
        s2.push('C');
        s2.push('B');
        s2.push('S');
        s2.push('T');
        s2.push('V');
        s3.push('C');
        s3.push('B');
        s3.push('S');
        s3.push('N');
        s3.push('W');
        s4.push('Q');
        s4.push('G');
        s4.push('M');
        s4.push('N');
        s4.push('J');
        s4.push('V');
        s4.push('C');
        s4.push('P');
        s5.push('T');
        s5.push('S');
        s5.push('L');
        s5.push('F');
        s5.push('D');
        s5.push('H');
        s5.push('B');
        s6.push('J');
        s6.push('V');
        s6.push('T');
        s6.push('W');
        s6.push('M');
        s6.push('N');
        s7.push('P');
        s7.push('F');
        s7.push('L');
        s7.push('C');
        s7.push('S');
        s7.push('T');
        s7.push('G');
        s8.push('B');
        s8.push('D');
        s8.push('Z');
        s9.push('M');
        s9.push('N');
        s9.push('Z');
        s9.push('W');

        for (String s: moveInput) {
            String[] eachWord = s.split(" ");
            int max = Integer.parseInt(eachWord[1]);
            int stack1 = Integer.parseInt(eachWord[3]);
            int stack2 = Integer.parseInt(eachWord[5]);
            char[] temp = new char[max];
            for(int i = 0; i < max; i++){
                switch (stack1) {
                    case 1 -> {
                        temp[i] = s1.firstElement();
                        s1.pop();
                    }
                    case 2 -> {
                        temp[i] = s2.firstElement();
                        s2.pop();
                    }
                    case 3 -> {
                        temp[i] = s3.firstElement();
                        s3.pop();
                    }
                    case 4 -> {
                        temp[i] = s4.firstElement();
                        s4.pop();
                    }
                    case 5 -> {
                        temp[i] = s5.firstElement();
                        s5.pop();
                    }
                    case 6 -> {
                        temp[i] = s6.firstElement();
                        s6.pop();
                    }
                    case 7 -> {
                        temp[i] = s7.firstElement();
                        s7.pop();
                    }
                    case 8 -> {
                        temp[i] = s8.firstElement();
                        s8.pop();
                    }
                    case 9 -> {
                        temp[i] = s9.firstElement();
                        s9.pop();
                    }
                }
            }
            for(int i = max-1; i > -1; i--){
                switch (stack2) {
                    case 1 -> s1.push(temp[i]);
                    case 2 -> s2.push(temp[i]);
                    case 3 -> s3.push(temp[i]);
                    case 4 -> s4.push(temp[i]);
                    case 5 -> s5.push(temp[i]);
                    case 6 -> s6.push(temp[i]);
                    case 7 -> s7.push(temp[i]);
                    case 8 -> s8.push(temp[i]);
                    case 9 -> s9.push(temp[i]);
                }
            }
        }
        System.out.println(s1.firstElement() + " " + s2.firstElement()+ " "+ s3.firstElement() + " " + s4.firstElement()+ " " + s5.firstElement()
                + " " + s6.firstElement() + " " + s7.firstElement() + " " + s8.firstElement() + " " + s9.firstElement());
    }
}