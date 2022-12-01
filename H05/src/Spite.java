/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler kooperiert, bis der gegner betruegt.
 * Danach betruegt der Spieler immer.
 */
public class Spite implements GefangenenStrategie {

    private boolean betrayed = false;

    @Override
    public boolean getNextDecision() {
        return !betrayed;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        betrayed = betrayed || !decision;
    }
}
