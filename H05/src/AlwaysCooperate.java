/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler immer mit dem anderen kooperiert.
 */
public class AlwaysCooperate implements GefangenenStrategie{
    @Override
    public boolean getNextDecision() {
        return true;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
    }
}