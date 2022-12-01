import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Test-Klasse
 */
public class DasSpiel {

    /**
     * Main-Funktion der Test-Klasse
     */
    public static void main(String[] args) {
        // Neues Objekt vom Typ GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd = new GefangenenDilemma(
            new TitForTat(),new PerKind());
        // 100 Mal spielen
        gd.spiele(100);

        System.out.println("\n");

        @SuppressWarnings("unchecked")
        final Class<? extends GefangenenStrategie>[] STRATEGIEN =
            (Class<? extends GefangenenStrategie>[]) new Class[]{
                AlwaysCooperate.class,
                AlwaysDefect.class,
                GoByMajority.class,
                Gradual.class,
                Mistrust.class,
                Pavlov.class,
                PerKind.class,
                PerNasty.class,
                Prober.class,
                Random.class,
                Spite.class,
                TitForTat.class,
                TitForTwoTats.class
        };


        String result = "";
        try {
            result = doTournament(STRATEGIEN, 100);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\n");
        System.out.println(result);

        try {
            Files.writeString(Path.of("ergebnisse.txt"), result, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben");
        }
    }

    /**
     * Erstellt neue Instanzen anhand der Strategien und
     * laesst jede gegen jede fuer mehrere Runden gegeneinander antreten.
     * @param strategien Die Strategien
     * @param count Anzahl der Runden
     * @return Tabelle, mit Zeilen und Spalten-Titel.<br>
     * "Koop" bedeutet, dass die beiden Spieler immer kooperiert haben.<br>
     * "Mistrust" bedeutet, dass die beiden SPieler sich immer betrogen haben.
     */
    public static String doTournament(Class<? extends GefangenenStrategie>[] strategien, int count) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String[] names = new String[strategien.length];
        for (int i = 0; i < strategien.length; i++) {
            names[i] = strategien[i].getSimpleName();
        }

        Ergebnis[][] ergebnisse = new Ergebnis[strategien.length][strategien.length];

        for (int i = 0; i < strategien.length; i++) {
            for (int j = 0; j < strategien.length; j++) {
                GefangenenDilemma gd = new GefangenenDilemma(
                    strategien[i].getDeclaredConstructor().newInstance(),
                    strategien[j].getDeclaredConstructor().newInstance()
                );
                ergebnisse[i][j] = gd.spiele(count);
            }
        }

        StringBuilder sb = new StringBuilder();
        int max_name = -1;
        for (String name : names) {
            max_name = Math.max(max_name, name.length() + 1);
        }
        max_name = Math.max(8, max_name);

        sb.append(String.format("%" + max_name + "s", ""));
        for (String name : names) {
            sb.append(String.format("%-" + max_name + "s", name));
        }

        sb.append('\n');
        for (int i = 0; i < ergebnisse.length; i++) {
            sb.append(String.format("%-" + max_name + "s", names[i]));
            for (Ergebnis e : ergebnisse[i]) {
                if (e.p1 == e.p2) {
                    if (e.p1 == 2 * count) {
                        sb.append(String.format("%-" + max_name + "s", "Coop"));
                        continue;
                    } else if (e.p2 == 4 * count) {
                        sb.append(String.format("%-" + max_name + "s", "Mistrust"));
                        continue;
                    }
                }
                sb.append(String.format("%3d:%3d ", e.p2, e.p1));
                sb.append(" ".repeat(max_name - 8));
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

}
