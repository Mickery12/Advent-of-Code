import java.util.ArrayList;

/**
 * Stellt eine Koenig-Schachfigur dar. Kann sich in eine beliebige Richtung bewegen, aber nur ein Feld.
 */
public class King extends Chessman {

    /**
     * Erstellt eine Koenig-Schachfigur an der Position.
     * @param pos Position der Schachfigur
     */
    public King(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine Liste der Positionen zurueck, zu denen der Koenig ziehen kann.
     * @return Liste der erlaubten Zuege
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        for (int x=Math.max(this.pos.getX()-1, 1); x<=Math.min(this.pos.getX()+1,8); x++) {
            for (int y=Math.max(this.pos.getY()-1, 1); y<=Math.min(this.pos.getY()+1,8); y++) {
                if (x!=this.pos.getX() || y!=this.pos.getY()) {
                    possibleMoves.add(new Position(x, y));
                }
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "Koenig: " + this.pos;
    }
}
