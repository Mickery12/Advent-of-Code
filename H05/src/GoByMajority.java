/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler beim ersten Mal kooperiert
 * und danach immer die Entscheidung waehlt,
 * die der Gegner am meisten genutzt hat.
 */
public class GoByMajority implements GefangenenStrategie{
   
   private int betrayed = 0;
   private int cooperated = 0;
    
    @Override
    public boolean getNextDecision() {
        return betrayed <= cooperated;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
        if (decision){
            cooperated++;
        } else {
            betrayed++;
        }
    }
}
