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

        Pawn pawn1 = (Pawn) board.getPiece(new Coordinate(2,3));

        UtilsUI.printPossibleMoves(pawn1);

        pawn1.move(new Coordinate(2,5));

        System.out.println();
        System.out.println(board.toString());
        System.out.println();
        UtilsUI.printPossibleMoves(pawn1);

        pawn1.move(new Coordinate(2,6));

        System.out.println();
        System.out.println(board.toString());
        System.out.println();
        UtilsUI.printPossibleMoves(pawn1);

        pawn1.move(new Coordinate(1,7));

        System.out.println();
        System.out.println(board.toString());
        System.out.println();
        UtilsUI.printPossibleMoves(pawn1);
    }
}
