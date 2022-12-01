import java.util.ArrayList;

/**
 * Stellt eine Laeufer-Schachfigur dar.
 * Diese kann sich mehrere Felder in einer Geraden Linie auf einer Diagonalen bewegen.
 */
public class Bishop extends Chessman {

    /**
     * Erstellt eine Lauefer-Schachfigur an der Position.
     * @param pos Position der Schachfigur
     */
    public Bishop(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen der Lauefer ziehen kann.
     * @return Liste der erlaubten Zuege
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int x = this.pos.getX();
        int y = this.pos.getY();
        for (int i = 1; i < x; i++) {
            addMoveIfValid(possibleMoves, x-i, y-i);
            addMoveIfValid(possibleMoves, x-i, y+i);
        }
        for (int i = 1; i <= 8-x; i++) {
            addMoveIfValid(possibleMoves, x+i, y-i);
            addMoveIfValid(possibleMoves, x+i, y+i);
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "Laeufer: " + this.pos;
    }
}
