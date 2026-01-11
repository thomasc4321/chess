package ui;

import mechanics.Coordinate;
import pieces.Piece;

public final class UtilsUI {
    private UtilsUI(){}

    public static void printPossibleMoves(Piece piece){
        for(Coordinate move : piece.getPossibleMoves()){
            if(move != null){
                System.out.println(move);
            }
        }
    }
}
