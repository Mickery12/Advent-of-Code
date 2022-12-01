/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler in der ersten Runde kooperiert und danach immer kooperiert,
 * wenn die beiden Spieler in der vorherigen Runde die gleiche Entscheidung getroffen haben.
 * Sonst betruegt er.
 */
public class Pavlov implements GefangenenStrategie {

    private boolean ownMove = true;
    private boolean oppLastMove = true;

    @Override
    public boolean getNextDecision() {
        ownMove = ownMove == oppLastMove;
        return ownMove;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        oppLastMove = decision;
    }
}
