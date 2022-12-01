import java.util.ArrayList;

/**
 * Stellt eine Schachfigur auf einem leeren Schachbrett dar.
 * Das Schachbrett besteht aus 8x8 Felder und reicht von (1,1) bis (8,8)
 */
public abstract class Chessman {
    protected Position pos;

    /**
     * Setzt die Position der Schachfigur auf die angegebene Position.
     * @param pos Position der Schachfigur
     */
    public Chessman(Position pos) {
        this.pos = pos;
    }

    /**
     * Gibt die Position der Schachfigur zurueck.
     * @return Position der Schachfigur
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Bewegt die Figur zu der Position, wenn es ein gueltiger Zug ist.
     * Sonst wird eine Exception geworfen.
     * @param pos Position zu der die Figur ziehen soll
     */
    public void moveTo(Position pos) {
        if (!canMoveTo(pos)) {
            throw new WrongMoveException("Die Figur kann nicht in einem Zug die Position " + pos + " erreichen");
        }
        this.pos = pos;
    }

    /**
     * Fuegt die Position zu der mitgegebenen Liste hinzu, wenn sie im Interval [1;8] liegt.
     * @param moves Liste zu der die Position hinzugefuegt werden soll
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    protected void addMoveIfValid(ArrayList<Position> moves, int x, int y) {
        if (Position.isValid(x, y)) {
            moves.add(new Position(x, y));
        }
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen die Figur ziehen darf.
     * @return List der erlaubten Positionen
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Gibt true zurueck, wenn die Position zu den erlaubten Zuegen gehoert.
     * @param pos Position, die ueberprueft werden soll
     * @return Position ist ein erlaubter Zug
     */
    public boolean canMoveTo(Position pos) {
        return getMoveList().contains(pos);
    }

}
