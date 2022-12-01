import java.util.ArrayList;

/**
 * Stellt eine Springer-Schachfigur dar.
 * Kann sich entweder in x-Richtung 2 Felder und in y-Richtung ein Feld
 * oder in y-Richtung 2 Felder und in x-Richtung 1 Feld bewegen.
 */
public class Knight extends Chessman {

    /**
     * Erstellt eine Springer-Schachfigur an der Position.
     * @param pos Position der Schachfigur
     */
    public Knight(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen der Springer ziehen kann.
     * @return Liste der erlaubten Zuege
     */
    @Override
    public ArrayList<Position> getMoveList() {
        final int[][] offs = {
            {-2, -1},
            {-2,  1},
            { 2, -1},
            { 2,  1}
        };
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int x = this.pos.getX();
        int y = this.pos.getY();
        for (int[] o : offs) {
            addMoveIfValid(possibleMoves, x+o[0], y+o[1]);
            addMoveIfValid(possibleMoves, x+o[1], y+o[0]);
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "Springer: " + this.pos;
    }
}
