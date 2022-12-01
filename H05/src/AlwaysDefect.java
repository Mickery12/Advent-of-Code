/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler immer den anderen Spieler betruegt.
 */
public class AlwaysDefect implements GefangenenStrategie{
    @Override
    public boolean getNextDecision() {
        return false;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
    }
}
