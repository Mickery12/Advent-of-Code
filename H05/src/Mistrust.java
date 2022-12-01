/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * bei der der Spieler beim ersten Mal betruegt und
 * danach immer die letzte Entscheidung des Gegners kopiert.
 */
public class Mistrust implements GefangenenStrategie {

    private boolean oLastMove = false;

    @Override
    public boolean getNextDecision() {
        return oLastMove;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        oLastMove = decision;
    }
}
