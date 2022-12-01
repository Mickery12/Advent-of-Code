/**
 * Eine Strategie fuer das Spiel Gefangenendilemma, wobei der Spieler erst einmal kooperiert und dann zweimal betruegt.
 * Kooperiert der Gegner in der zweiten oder dritten Runde,
 * betruegt der Spieler danach immer. Sonst spielt er nach der Strategie "TitForTat".
 */
public class Prober implements GefangenenStrategie {
    private int count = 0;
    private boolean type = true;
    private boolean oLastMove = true;

    @Override
    public boolean getNextDecision() {
        if (count < 4) return count == 1;

        if (!type) return false;

        return oLastMove;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        oLastMove = decision;
        count++;
        if ((count == 2 || count == 3) && decision) {
            type = false;
        }
    }
}
