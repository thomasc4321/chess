import mechanics.Board;
import mechanics.BoardFactory;
import mechanics.Coordinate;
import pieces.*;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.createTestBoard();

        System.out.println(board.toString());

        board.setPiecesRank(2, PieceType.PAWN, true);
        board.setPiecesRank(7, PieceType.PAWN, false);

        System.out.println();
        System.out.println(board.toString());
        System.out.println();

        Pawn pawn1 = (Pawn) board.getPiece(new Coordinate(2,2));

        Coordinate[] possibleMoves = pawn1.getPossibleMoves(board);
        for(Coordinate move : possibleMoves){
            if(move != null){
                System.out.println(move);
            }
        }
    }
}
