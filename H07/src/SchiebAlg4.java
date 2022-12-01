/**
 * Der Algorithmus verschiebt so lange zufaellig Plaettchen, bis die erste Zeile sortiert ist und das leere Plaettchen unten rechts steht.
 */


public class SchiebAlg4 implements Loesungsalgorithmus {
    @Override
    public void loese(Schiebepuzzle puzzle) {
        while (puzzle.getZahlAnPos(0, 0) != 1 || puzzle.getZahlAnPos(0, 1) != 2 || puzzle.getZahlAnPos(0, 2) != 3
           || puzzle.getZahlAnPos(0,3) != 4 ||puzzle.getZahlAnPos(3,3) != 0) {
            int zufallsZahl = (int) (Math.random() * (16 - 1) + 1);
            try {
                puzzle.schiebe(zufallsZahl);
            } catch (WrongMoveException ignored) {
            }
        }
        
    }
}
