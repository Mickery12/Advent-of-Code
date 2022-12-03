import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Priorities {

    private static List<String> getBackpackContents() throws IOException {
        return Files.readAllLines(Path.of("backpacks.txt"));
    }
    public static int getSumItemPriorities() throws IOException {
        List<String> priorities = getBackpackContents();
        int sum = 0;
        outer:
        for (String s : priorities)
        {
            char[] ca1 = s.substring(0, (s.length())/2).toCharArray();
            char[] ca2 = s.substring((s.length())/2).toCharArray();
            for (char c1: ca1) {
                for (char c2: ca2){
                    if (c1 == c2){
                        sum += getPriorityNumberFromChar(c1);
                        continue outer;
                    }
                }
            }
        }
        return sum;
    }

    public static int getSumBadges() throws IOException {
        List<String> badges = getBackpackContents();
        int sum = 0;
        outer:
        for (int i = 0; i < badges.size(); i+=3)
        {
            char[] ca1 = badges.get(i).toCharArray();
            char[] ca2 = badges.get(i+1).toCharArray();
            char[] ca3 = badges.get(i+2).toCharArray();
            for (char c1: ca1) {
                for (char c2: ca2){
                    for (char c3: ca3) {
                        if (c1 == c2 && c1 == c3){
                            sum+= getPriorityNumberFromChar(c1);
                            continue outer;
                        }
                    }
                }
            }
        }
        return sum;
    }
    private static int getPriorityNumberFromChar(char c) {
        return Character.isLowerCase(c) ? c-96 : c - 38;
    }
}
