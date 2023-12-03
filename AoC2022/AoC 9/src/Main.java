import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(PuzzleSolver.solvePuzzle(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            System.out.println(PuzzleSolver.solvePuzzle(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}