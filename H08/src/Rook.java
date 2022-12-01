import java.util.ArrayList;

/**
 * Stellt eine Turm-Schachfigur dar. Diese kann sich in einer Geraden Linie
 * mehrere Felder auf einer Horizontalen oder Vertikalen bewegen.
 */
public class Rook extends Chessman {

    /**
     * Erstellt eine Turm-Schachfigur an der Position.
     * @param pos Position der Schachfigur
     */
    public Rook(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen der Turm ziehen kann.
     * @return Liste der erlaubten Zuege
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            if (i != this.pos.getY()) {
                possibleMoves.add(new Position(this.pos.getX(), i));
            }
            if (i != this.pos.getX()) {
                possibleMoves.add(new Position(i, this.pos.getY()));
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "Turm: " + this.pos;
    }
}
