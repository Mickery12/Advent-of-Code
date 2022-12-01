/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler beim ersten Mal kooperiert.
 * Hat der Gegner in der letzten Runde kooperiert, kooperiert der Spieler.
 * Hat der Gegner betrogen, betruegt der Spieler mit einer Wahrscheinlichkeit von 50 %.
 * Sonst kooperiert er.
 */
public class TitForTwoTats implements GefangenenStrategie{
    
    private boolean oLastDecision = true;
    @Override
    public boolean getNextDecision() {
        if(!oLastDecision) {
            return Math.random() >= 0.5;
        }
        return true;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
        oLastDecision = decision;
    }
}
