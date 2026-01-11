package mechanics;

import pieces.PieceType;

public final class BoardFactory {
    private BoardFactory(){}

    public static Board createClassicBoard(){
        Board board = new Board();

        board.setPiecesRank(2, PieceType.PAWN, true);
        board.setPiecesRank(7, PieceType.PAWN, false);

        return board;
    }

    public static Board createTestBoard(){
        Board board = new Board();

        board.setPiecesRank(2, PieceType.PAWN, true);
        board.setPiecesRank(3, PieceType.PAWN, true);
        board.setPiecesRank(7, PieceType.PAWN, false);

        return board;
    }
}
