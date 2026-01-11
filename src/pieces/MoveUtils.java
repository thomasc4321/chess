package pieces;

import mechanics.Coordinate;
import mechanics.GameLogic;

import java.util.ArrayList;

public final class MoveUtils {

    private MoveUtils(){}

    /**
     * Searches all diagonal lines for possible moves
     * @param piece
     * @return
     */
    public static Coordinate[] checkStraightLinesLong(Piece piece){
        //TODO:
        return new Coordinate[0];
    }

    /**
     * Searches all diagonal lines for possible moves
     * @param piece
     * @return
     */
    public static Coordinate[] checkDiagonalsLong(Piece piece){
        Coordinate[] moves = new Coordinate[13];
        int moveIndex = 0;

        //gather all diagonals
        ArrayList<Coordinate> combinedCoordinates = searchDiagonalLong(true, true, piece);
        combinedCoordinates.addAll(searchDiagonalLong(true, false, piece));
        combinedCoordinates.addAll(searchDiagonalLong(false, true, piece));
        combinedCoordinates.addAll(searchDiagonalLong(false, false, piece));

        for(Coordinate validMove : combinedCoordinates){
            moves[moveIndex] = validMove;
            moveIndex++;
        }

        return moves;
    }

    /**
     * Searches along the given diagonal line for possible moves
     * @param searchLeft
     * @param searchUp
     * @param piece
     * @return
     */
    private static ArrayList<Coordinate> searchDiagonalLong(boolean searchLeft, boolean searchUp, Piece piece){
        Coordinate checkCoordinate = piece.getPosition();
        int moveDirectionHorizontal = searchLeft ? -1 : 1;
        int moveDirectionVertical = searchUp ? 1 : -1;

        ArrayList<Coordinate> moves = new ArrayList(8);

        checkCoordinate = new Coordinate(checkCoordinate.file()+moveDirectionHorizontal, checkCoordinate.rank()+moveDirectionVertical);

        while(checkCoordinate.file() > 0 && checkCoordinate.rank() > 0 && checkCoordinate.file() <= 8 && checkCoordinate.rank() <= 8){
            Piece checkedTile = piece.board.getPiece(checkCoordinate);
            if(checkedTile != null){
                if(GameLogic.arePiecesOpposing(piece, checkedTile)){
                    moves.add(checkCoordinate);
                }
                break;
            }
            moves.add(checkCoordinate);
            checkCoordinate = new Coordinate(checkCoordinate.file()+moveDirectionHorizontal, checkCoordinate.rank()+moveDirectionVertical);
        }

        return moves;
    }
}
