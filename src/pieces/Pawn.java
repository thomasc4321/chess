package pieces;
import mechanics.*;

public class Pawn extends Piece{
    boolean hasMoved = false;

    public Pawn(Coordinate position, boolean isWhite){
        super("P", position, isWhite);
    }

    @Override
    public Coordinate[] getPossibleMoves(Board board) {
        Coordinate[] moves = new Coordinate[64];
        int moveIndex = 0;
        int movementDirection = isWhite ? 1 : -1;

        //is pawn somehow at the final rank on a new turn
        if(position.rank() >= GameSettings.FILE_LENGTH*movementDirection){
            System.out.println("PIECE ERROR: Pawn at back rank and trying to move");
            return moves;
        }

        //check if can move to next tile
        Coordinate nextTile = new Coordinate(position.file(), position.rank()+movementDirection);
        if(board.getPiece(nextTile) == null){
            moves[moveIndex] = nextTile;
            moveIndex++;

            //check if can move two squares
            nextTile = new Coordinate(position.file(), position.rank()+movementDirection*2);
            if(!hasMoved && board.getPiece(nextTile) == null){
                moves[moveIndex] = nextTile;
                moveIndex++;
            }
        }

        //check if can eat left (from white POV)
        nextTile = new Coordinate(position.file()-1, position.rank()+movementDirection);
        if(position.file() > 1){
            Piece otherPiece = board.getPiece(nextTile);
            if(otherPiece != null && GameLogic.arePiecesOpposing(this, otherPiece)){
                moves[moveIndex] = nextTile;
                moveIndex++;
            }
        }

        //check if can eat right (from white POV)
        nextTile = new Coordinate(position.file()+1, position.rank()+movementDirection);
        if(position.file() < GameSettings.RANK_LENGTH && board.getPiece(nextTile) != null){
            Piece otherPiece = board.getPiece(nextTile);
            if(otherPiece != null && GameLogic.arePiecesOpposing(this, otherPiece)){
                moves[moveIndex] = nextTile;
                moveIndex++;
            }
        }

        return moves;
    }

    @Override
    public void move(Coordinate coordinate){
        hasMoved = true;
    }
}
