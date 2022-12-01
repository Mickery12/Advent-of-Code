/**
 * Stell eine Position auf einem 8x8 Schachbrett dar. Startet bei 1.
 */
public class Position {

    private final int x;
    private final int y;

    /**
     * Initialisiert den Punkt mit x als X-Koordinate und y als Y-Koordinate. Wirft eine Exception bei invaliden Koordinaten
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @throws WrongPositionException Wird geworfen, wenn x oder y nicht im Interval [1;8] liegen.
     */
    public Position(int x, int y) {
        if (!Position.isValid(x, y)) {
            throw new WrongPositionException("Die Koordinaten einer Position muessen im Interval [1;8] liegen.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die X-Koordinate der Position zurueck.
     * @return Y-Koordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gibt die Y-Koordinate der Position zurueck.
     * @return Y-Koordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vergleicht die Objekte. Gibt true zurueck, wenn das angegebene Objekt auch eine Position ist,
     * die die gleichen Koordinaten besitzt.
     * @param o anderes Objekt
     * @return gleicher Punkt
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Position p) {
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }

    /**
     * Gibt true zurueck, wenn die Koordinaten der Positionen uebereinstimmen.
     * @param p anderer Punkt
     * @return haben die gleichen Koordinaten
     */
    public boolean equals(Position p) {
        return p.x == this.x && p.y == this.y;
    }

    /**
     * Gibt true zurueck, wenn x und y im erlaubten Intervale [1;8] liegen.
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @return liegt im erlaubten Bereich
     */
    public static boolean isValid(int x, int y) {
        return x > 0 && x <= 8 && y > 0 && y <= 8;
    }

    /**
     * Gibt die Position in dem Format (x,y) zurueck.
     * @return Textdarstellung der Position
     */
    @Override
    public String toString() {
        return "("+x+"/"+y+")";
    }

}
