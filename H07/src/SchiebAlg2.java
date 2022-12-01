/**
 * Der Algorithmus verschiebt so lange zufaellig Plaettchen, bis die 1 und die 2 an der richtigen Stelle stehen.
 */

public class SchiebAlg2 implements Loesungsalgorithmus{
    @Override
    public void loese(Schiebepuzzle puzzle) {
        while (puzzle.getZahlAnPos(0, 0) != 1 || puzzle.getZahlAnPos(0, 1) != 2) {
            int zufallsZahl = (int) (Math.random() * (16 - 1) + 1);
            try {
                puzzle.schiebe(zufallsZahl);
            } catch (WrongMoveException ignored) {
            }
        }
    }
}
