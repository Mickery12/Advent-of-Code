/**
 * Interface fuer eine Strategie von dem Spiel Gefangenendilemma
 */
public interface GefangenenStrategie {

    /**
     * Gibt die naechste Entscheidung entsprechend der Strategie zurueck.
     * Dabei steht true fuer das Kooperieren mit und false fuer das Betruegen des Gegners.
     * @return Entscheidung
     */
    public boolean getNextDecision();

    /**
     * Methode um auf die letzte Entscheidung Gegners der Strategie entsprechend zu reagieren.
     * @param decision Entscheidung des Gegners in der letzten Runde
     */
    public void setOpponentLastDecision(boolean decision);

}
