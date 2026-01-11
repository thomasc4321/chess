package mechanics;

import pieces.Pawn;
import pieces.Piece;
import pieces.PieceType;

public final class GameLogic {
    public static boolean arePiecesOpposing(Piece piece1, Piece piece2){
        if(piece1.isWhite != piece2.isWhite){
            return true;
        }

        return false;
    }

    public static Piece createPieceFromType(PieceType type, Coordinate coordinate, boolean isWhite){
        switch(type){
            case PAWN -> {
                return new Pawn(coordinate, isWhite);
            }
            default -> {
                return null;
            }
        }
    }

    private GameLogic(){};
}
