import jdk.jshell.execution.Util;
import mechanics.Board;
import mechanics.BoardFactory;
import mechanics.Coordinate;
import pieces.*;
import ui.UtilsUI;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.createTestBoard();

        System.out.println(board.toString());

        board.setPiecesRank(2, PieceType.PAWN, true);
        board.setPiecesRank(7, PieceType.PAWN, false);

        System.out.println();
        System.out.println(board.toString());
        System.out.println();

        Queen queen1 = (Queen) board.getPiece(new Coordinate(4,4));

        UtilsUI.printPossibleMoves(queen1);
        UtilsUI.displayPossibleMoves(queen1);
        System.out.println();

        queen1.move(new Coordinate(4, 7));

        UtilsUI.printPossibleMoves(queen1);
        UtilsUI.displayPossibleMoves(queen1);
        System.out.println();
    }
}
