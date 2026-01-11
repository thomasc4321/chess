package ui;

import mechanics.Board;
import mechanics.Coordinate;
import mechanics.GameLogic;
import pieces.Piece;
import pieces.PieceType;

public final class UtilsUI {
    private UtilsUI(){}

    public static void printPossibleMoves(Piece piece){
        for(Coordinate move : piece.getPossibleMoves()){
            if(move != null){
                System.out.println(move);
            }
        }
    }

    public static void displayPossibleMoves(Piece piece){
        Board displayBoard = new Board();
        displayBoard.setBoard(piece.getBoard().getBoardState());

        Coordinate[] validMoves = piece.getPossibleMoves();

        Piece attackedPiece;
        boolean isAttacking = false;
        for(Coordinate moveCoordinate : validMoves){
            if(moveCoordinate != null){
                attackedPiece = piece.getBoard().getPiece(moveCoordinate);
                if(GameLogic.arePiecesOpposing(piece, attackedPiece)){
                    isAttacking = true;
                }
                displayBoard.setPiece(moveCoordinate, GameLogic.createPieceFromType(displayBoard, PieceType.DUMMY, moveCoordinate, isAttacking));
                isAttacking = false;
            }
        }

        System.out.println(displayBoard);
    }
}
