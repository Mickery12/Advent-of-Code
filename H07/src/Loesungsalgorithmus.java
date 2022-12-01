/**
 * Interface fuer Loesungsalgorithmen zum Loesen des Puzzles.
 */
public interface Loesungsalgorithmus {

    /**
     * Loest das mitgegebene Puzzle nach den entsprechenden Kriterien des Loesungsalgorithmus.
     * @param puzzle das zu loesende Puzzle.
     */
    void loese(Schiebepuzzle puzzle);
}
