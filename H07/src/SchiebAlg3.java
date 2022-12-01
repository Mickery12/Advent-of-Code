/**
 * Der Algorithmus verschiebt so lange zufaellig Plaettchen, bis 1, 2, 3 an der richtigen Stelle stehen und das leere Plaettchen unten rechts.
 */

public class SchiebAlg3 implements Loesungsalgorithmus{
    @Override
    public void loese(Schiebepuzzle puzzle) {
        while (puzzle.getZahlAnPos(0, 0) != 1 || puzzle.getZahlAnPos(0, 1) != 2 || puzzle.getZahlAnPos(0, 2) != 3 || puzzle.getZahlAnPos(3,3) != 0) {
            int zufallsZahl = (int) (Math.random() * (16 - 1) + 1);
            try {
                puzzle.schiebe(zufallsZahl);
            } catch (WrongMoveException ignored) {
            }
        }
    }
}