/**
 * Eine Strategie fuer das Spiel Gefangenendilemma,
 * wobei der Spieler kooperiert, bis der Gegner betruegt. Er betruegt danach einmal und kooperiert zweimal.
 * Betruegt der Gegner nach dieser Sequenz erneut, betruegt der Spieler zweimal und kooperiert dann zweimal.
 * Wann immer der Spieler nicht in der Sequenz ist und der andere Spieler betruegt, beginnt der Spieler also eine Sequenz,
 * bei der er beim ersten Mal einmal beim zweiten Mal zweimal betruegt. Also immer einmal mehr.
 * Danach kooperiert er zweimal, bevor die Sequenz endet.
 */
public class Gradual implements GefangenenStrategie {

    int betrayCount = 0;
    int revenge = -2;

    @Override
    public boolean getNextDecision() {
        if (revenge > -2) {
            revenge--;
        }
        return revenge < 0;
    }

    @Override
    public void setOpponentLastDecision(boolean decision) {
        if (revenge == -2 && !decision) {
            betrayCount++;
            revenge = betrayCount;
        }
    }
}
