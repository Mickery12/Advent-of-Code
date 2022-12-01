/**
 * Test-Klasse fuer SchachFiguren
 * @author Samuel Thesing, Michael Conrads, Jonas Feldbruegge
 */
public class Main {
    public static void main(String[] args) {
        // Test eines Turms
        System.out.println("Test Turm:");
        Rook rook = new Rook(new Position(4,5));
        System.out.println(rook);
        rook.moveTo(new Position(4,1));
        System.out.println(rook);
        System.out.println(rook.getMoveList());

        // Test eines Springers
        System.out.println("\nTest Springer:");
        Knight knight = new Knight(new Position(5,4));
        System.out.println(knight);
        knight.moveTo(new Position(6,6)); // mitten auf dem Feld
        System.out.println(knight);
        System.out.println(knight.getMoveList());
        knight.moveTo(new Position(8,5)); // am Rand des Feldes
        System.out.println(knight);
        System.out.println(knight.getMoveList());

        // Test eines Laeufers
        System.out.println("\nTest Lauefer:");
        Bishop bishop = new Bishop(new Position(2, 3));
        System.out.println(bishop);
        System.out.println(bishop.getMoveList());
        bishop.moveTo(new Position(3, 4));
        System.out.println(bishop);
        System.out.println(bishop.getMoveList());

        // Test eines Keonigs
        System.out.println("\nTest Koenig:");
        King king = new King(new Position(2, 3));
        System.out.println(king);
        System.out.println(king.getMoveList());
        king.moveTo(new Position(1, 2));
        System.out.println(king);
        System.out.println(king.getMoveList());

        // Test einer Dame
        System.out.println("\nTest Dame:");
        Queen queen = new Queen(new Position(6, 2));
        System.out.println(queen);
        System.out.println(queen.getMoveList());
        queen.moveTo(new Position(5, 1));
        System.out.println(queen);
        System.out.println(queen.getMoveList());
    }
}