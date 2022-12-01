/**
 * Stellt ein Schiebepuzzle der Groesse 4x4 mit 15 Plaettchen dar.
 * @author Samuel Thesing, Jonas Feldbruegge, Michael Conrads
 */

public class Schiebepuzzle {

    private final int[][] puzzle;
    private int[] pNull;

    /**
     * Erzeugt ein Schiebepuzzle, in dem die Zahlen sortiert sind.
     * */
    public Schiebepuzzle(){
        this.puzzle = new int[4][4];
        fuellePuzzle();
    }

    /**
     * befuellt das Puzzle mit den Zahlen von 1 bis 15.
     */
    private void fuellePuzzle(){
        int i = 1;
        for (int[] ints : this.puzzle) {
            for (int j = 0; j < ints.length; j++) {
                if(i < this.puzzle.length*ints.length+1){
                    ints[j] = i%16;
                    i++;
                }
            }
        }
        pNull = new int[2];
        pNull[0] = 3;
        pNull[1] = 3;
    }

    /**
     * Gibt die Zahl des Plaettchen an der Stelle (x;y) zurueck.
     * @param x x-Position
     * @param y y-Position
     * @return Zahl des Plaettchen
     */
    public int getZahlAnPos(int x, int y) {
        return this.puzzle[x][y];
    }

    /**
     * Gibt eine Kopie des Felds zurueck.
     * @return Kopie des Puzzle-Feld
     */
    public int[][] getGridCopy() {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < this.puzzle.length; i++) {
            tmp[i] = this.puzzle[i].clone();
        }
        return tmp;
    }
    
    /**
     * Verschiebt das Plaettchen mit der mitgegebenen Zahl auf den freien Platz.
     * @param zahl Zahl, deren Plaettchen verschoben werden soll.
     * @throws WrongMoveException Falls die Zahl nicht verschoben werden kann.
     */
    public void schiebe(int zahl) throws WrongMoveException{
        int[] p = findeZahl(zahl);
        if(!istVerschiebbar(p)) {
            throw new WrongMoveException("Zug ist nicht moeglich");
        }
        this.puzzle[this.pNull[0]][this.pNull[1]] = this.puzzle[p[0]][p[1]];
        this.puzzle[p[0]][p[1]] = 0;
        this.pNull = p.clone();
    }

    /**
     * Ermittelt die Position der mitgegebenen Zahl.
     * @param zahl Zahl deren Position ermittelt wird.
     * @return die Position als int-Array.
     * @throws WrongNumberException Falls die Zahl nicht zwischen 1 und 15 liegt.
     */
    public int[] findeZahl(int zahl) throws WrongNumberException{
        for(int i = 0; i < this.puzzle.length; i++){
            for(int j = 0; j < this.puzzle[i].length; j++){
                if(this.puzzle[i][j] == zahl) {
                    return new int[]{i,j};
                }
            }
        }
        throw new WrongNumberException("i muss zwischen 1 und 15 liegen.");
    }

    /**
     * Prueft, ob das Plaettchen verschiebbar ist.
     * @param i Zahl des Plaettchens, das geprueft werden soll.
     * @return Ob der Abstand des Plaettchen zum leeren Feld = 1 ist.
     */
    public boolean istVerschiebbar(int i) { // Von der Aufgabenstellung gefordert
        return istVerschiebbar(findeZahl(i));
    }

    /**
     * Prueft, ob das Plaettchen einer Zahl verschiebbar ist.
     * @param pos Position des Plaettchen, das geprueft werden soll.
     * @return Ob der Abstand des Plaettchen zum leeren Feld = 1 ist.
     */
    private boolean istVerschiebbar(int[] pos){
        return 1 == Math.abs(pos[0] - this.pNull[0]) + Math.abs(pos[1] - this.pNull[1]);
    }

    /**
     * Mischt das Puzzle, indem sie 100 zufaellige (gueltige) Zuege vornimmt.
     */
    public void mische(){
        int i = 0;
        while(i < 100) {
            int zufallSpalte = (int) (Math.random() * 4);
            int zufallZeile = (int) (Math.random() * 4);
            try {
                i++;
                schiebe(this.puzzle[zufallSpalte][zufallZeile]);
            }
            catch (WrongMoveException | WrongNumberException ignored){
                i--;
            }
        }
    }

    /**
     * Wandelt das Puzzle in eine geeignete String-Darstellung um.
     * @return Die String-Darstellung des Puzzles.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("-".repeat(13) + "\n");
        for (int[] zeile : this.puzzle) {
            for (int element : zeile) {
                if (element == 0) {
                    sb.append("|  ");
                } else {
                    sb.append(String.format("|%2d", element));
                }
            }
            sb.append("|\n").append("-".repeat(13)).append("\n");
        }
        return sb.toString();
    }


}
