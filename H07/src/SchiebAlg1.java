/**
 * Der Algorithmus verschiebt so lange ein zufaelliges Plaettchen, bis die 1 oben links in der Ecke steht.
 */
public class SchiebAlg1 implements Loesungsalgorithmus{

    @Override
    public void loese(Schiebepuzzle puzzle) {
        while (puzzle.getZahlAnPos(0, 0) != 1) {
            int zufallsZahl = (int) (Math.random() * (16 - 1) + 1);
            try {
                puzzle.schiebe(zufallsZahl);
            } catch (WrongMoveException ignored) {
            }
        }
    }
}
