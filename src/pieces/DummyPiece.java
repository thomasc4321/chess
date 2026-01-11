package pieces;

import mechanics.Board;
import mechanics.Coordinate;

public class DummyPiece extends Piece{

    public DummyPiece(Board board, Coordinate position, boolean isWhite) {
        super(board, "X", position, isWhite, 0, PieceType.DUMMY);
    }

    @Override
    public Coordinate[] getPossibleMoves() {
        return new Coordinate[0];
    }
}
