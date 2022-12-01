/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler in einer festen Sequenz immer zweimal kooperiert und dann einmal betruegt.
 */
public class PerKind implements GefangenenStrategie {
    
    private int cycle = 0;
    
    @Override
    public boolean getNextDecision() {
        cycle++;
        return (cycle % 3) != 0;
    }
    
    @Override
    public void setOpponentLastDecision(boolean decision) {
    
    }
}
