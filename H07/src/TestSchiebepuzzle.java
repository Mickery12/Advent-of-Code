import full.Direction;
import full.Solver;

import java.util.List;

/**
 * Testklasse
 */
public class TestSchiebepuzzle {

    /**
     * Main-Funktion der Test-Klasse.
     */
    public static void main(String[] args) {
        Schiebepuzzle puzzle = new Schiebepuzzle();
        // Mischen nicht vergessen, sonst hat der Spieler sehr schnell gewonnen
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        Solver sv = new Solver();
        for (int i = 0; i < 2000; i++) {
            puzzle.mische();
            List<Direction> moves = sv.solve(puzzle.getGridCopy());
            int count = moves.size();
            total += count;
            min = Math.min(min, count);
            max = Math.max(max, count);
            System.out.println(i);
        }
        System.out.println("Total: "+total);
        System.out.println("Average: "+((float)total)/100);
        System.out.println("Minimal: "+min);
        System.out.println("Maximal: "+max);


        // Testen der Loesungsalgorithmen
        // -> zufaellig schieben
//        Loesungsalgorithmus alg1 = new SchiebAlg1();
//        Loesungsalgorithmus alg2 = new SchiebAlg2();
//        Loesungsalgorithmus alg3 = new SchiebAlg3();
//        Loesungsalgorithmus alg4 = new SchiebAlg4();
//        alg1.loese(puzzle);
//        System.out.println(puzzle);
//        puzzle.mische();
//        System.out.println(puzzle);
//        alg2.loese((puzzle));
//        System.out.println(puzzle);
//        puzzle.mische();
//        System.out.println(puzzle);
//        alg3.loese((puzzle));
//        System.out.println(puzzle);
//        puzzle.mische();
//        System.out.println(puzzle);
//        alg4.loese((puzzle));
//        System.out.println(puzzle);
    }
}