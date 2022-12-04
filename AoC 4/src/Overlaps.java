import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Overlaps {

    private static List<String> readList() throws IOException {
        return Files.readAllLines(Path.of("assignementPairs.txt"));
    }

    private static int compareStringsIncluding(String[] s1, String[] s2){
        int sum = 0;
        if(   (Integer.parseInt(s1[0]) <= Integer.parseInt(s2[0]) && Integer.parseInt(s1[1]) >= Integer.parseInt(s2[1]) )
           || (Integer.parseInt(s1[0]) >= Integer.parseInt(s2[0]) && Integer.parseInt(s1[1]) <= Integer.parseInt(s2[1]) )){
            sum++;
        }
        return sum;
    }

    private static int compareStringsOverlap(String[] s1, String[] s2){
        int sum = 0;
        if(   (Integer.parseInt(s1[0]) <= Integer.parseInt(s2[0]) && Integer.parseInt(s1[1]) >= Integer.parseInt(s2[0]))
           || (Integer.parseInt(s1[0]) >= Integer.parseInt(s2[0]) && Integer.parseInt(s1[1]) <= Integer.parseInt(s2[1]))
           || (Integer.parseInt(s1[0]) > Integer.parseInt(s2[0]) && Integer.parseInt(s1[0]) <= Integer.parseInt(s2[1]))
           || (Integer.parseInt(s1[0]) < Integer.parseInt(s2[0]) && Integer.parseInt(s1[1]) >= Integer.parseInt(s2[0]))){
            sum++;
        }
        return sum;
    }

    private static int splitAndCompareStrings(List<String> assignementPairs, int input) {
        int sum = 0;

        for (String s : assignementPairs) {
            String[] strings = s.split(",");
            String[] strings1 = new String[strings.length];
            String[] strings2 = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                if (i % 2 == 0) {
                    strings1 = strings[i].split("-");
                } else {
                    strings2 = strings[i].split("-");
                }
            }
            if(input == 1){
                sum += compareStringsIncluding(strings1, strings2);
            } else{
                sum += compareStringsOverlap(strings1, strings2);
            }
        }
        return sum;
    }
    public static int countSameAssignements(int input) throws IOException {
        List<String> assignementPairs = readList();
        return splitAndCompareStrings(assignementPairs, input);
    }
}

