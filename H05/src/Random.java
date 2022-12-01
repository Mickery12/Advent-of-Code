/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler zufaellig kooperiert oder betruegt.
 */
public class Random implements GefangenenStrategie{
    @Override
    public boolean getNextDecision() {
        return Math.random() >= 0.5;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
    
    }
}
