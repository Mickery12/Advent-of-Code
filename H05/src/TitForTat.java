/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler in der ersten Runde kooperiert und danach immer die letzte Entscheidung des Gegners kopiert.
 */
public class TitForTat implements GefangenenStrategie {

    private boolean oLastMove = true;

    @Override
    public boolean getNextDecision() {
        return oLastMove;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        oLastMove = decision;
    }
}
