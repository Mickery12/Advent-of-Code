import java.util.ArrayList;

/**
 * Stellt eine Dame-Schachfigur dar.
 * Kann sich mehrere Felder in einer geraden Linie horizontal, vertikal oder diagonal bewegen.
 */
public class Queen extends Chessman {

    /**
     * Erstellt eine Dame-Schachfigur an der Position.
     * @param pos Position der Schachfigur
     */
    public Queen(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen die Dame ziehen kann.
     * @return Liste der erlaubten Zuege
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int x = this.pos.getX();
        int y = this.pos.getY();
        for (int i = 1; i < x; i++) {
            addMoveIfValid(possibleMoves, x-i, y);
            addMoveIfValid(possibleMoves, x, y-i);
            addMoveIfValid(possibleMoves, x-i, y-i);
            addMoveIfValid(possibleMoves, x-i, y+i);
        }
        for (int i = 1; i <= 8-x; i++) {
            addMoveIfValid(possibleMoves, x+i, y);
            addMoveIfValid(possibleMoves, x, y+i);
            addMoveIfValid(possibleMoves, x+i, y-i);
            addMoveIfValid(possibleMoves, x+i, y+i);
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "Dame: " + this.pos;
    }
}
