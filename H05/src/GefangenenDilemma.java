/**
 * Stellt eine Partie des mathematischen Spiels "Gefangenendilemma" dar.
 * @author Samuel Thesing, Jonas Feldbruegge, Michael Conrads
 */
public class GefangenenDilemma {

    GefangenenStrategie s1;
    GefangenenStrategie s2;

    /**
     * Nimmt zwei Strategien an, die beim Aufruf der Methode {@link #spiele(int)} gegeneinander spielen
     * @param s1 erste Strategie
     * @param s2 zweite Strategie
     */
    public GefangenenDilemma(GefangenenStrategie s1, GefangenenStrategie s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * Laesst die beiden gespeicherten Strategien fuer mehrere Runden gegeneinander antreten
     * @param n Anzahl der Runden
     * @return
     */
    public Ergebnis spiele(int n) {
        int p1 = 0;
        int p2 = 0;
        boolean t1;
        boolean t2;

        for (int i = 0; i < n; i++) {
            t1 = s1.getNextDecision();
            t2 = s2.getNextDecision();

            if (t1 && t2) {
                p1 += 2;
                p2 += 2;
            } else if (!(t1 || t2)) {
                p1 += 4;
                p2 += 4;
            } else {
                p1 += t1 ? 6 : 1;
                p2 += t2 ? 6 : 1;
            }

            s1.setOpponentLastDecision(t2);
            s2.setOpponentLastDecision(t1);
        }

        if (p1 == p2) {
            System.out.println("Gleichstand: " + p1 + ":" + p2);
        } else if (p1 < p2) {
            System.out.println("Gefangener 1 gewinnt mit " + p1 + ":" + p2);
        } else {
            System.out.println("Gefangener 2 gewinnt mit " + p2 + ":" + p1);
        }

        return new Ergebnis(p1, p2);
    }

}
