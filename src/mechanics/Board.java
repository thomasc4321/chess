package mechanics;

import pieces.*;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board(){

    }

    /**
     * completely resets state of the board 2D array. Warning: new pieces are created
     * @param copyOfBoard
     */
    public void setBoard(Piece[][] copyOfBoard){
        Piece oldPiece;
        for(int rank = 0; rank < GameSettings.RANK_LENGTH; rank++){
            for(int file = 0; file < GameSettings.FILE_LENGTH; file++){
                oldPiece = copyOfBoard[rank][file];

                if(oldPiece != null){
                    //warning, copied pieces are completely new, not retaining important data e.g. if pawn has moved
                    board[rank][file] = GameLogic.createPieceFromType(this,
                            oldPiece.pieceType, oldPiece.getPosition(), oldPiece.isWhite);
                }
            }
        }
    }

    public void setPiece(Coordinate coordinate, Piece piece){
        board[coordinate.rank()-1][coordinate.file()-1] = piece;
    }

    public void movePiece(Piece piece, Coordinate newCoordinate){
        setPiece(piece.getPosition(), null);
        setPiece(newCoordinate, piece);
    }

    public Piece getPiece(Coordinate coordinate){
        return board[coordinate.rank()-1][coordinate.file()-1];
    }

    public void setPiecesRank(int rank, PieceType pieceType, boolean isWhite){
        for(int i = 1; i <= GameSettings.RANK_LENGTH; i++){
            Coordinate newPosition = new Coordinate(i, rank);
            setPiece(newPosition, GameLogic.createPieceFromType(this, pieceType, newPosition, isWhite));
        }
    }

    public Piece[][] getBoardState(){
        return board;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        int rank = 8;
        for(int i = board.length-1; i >= 0; i--) {
            output.append("| ");
            for(Piece piece : board[i]){
                if(piece != null){
                    if(piece.isWhite){
                        output.append(piece.representation);
                    }
                    else{
                        output.append(piece.representation.toLowerCase());
                    }
                }
                else{
                    output.append(" ");
                }
                output.append(" | ");
            }
            output.append(rank);
            rank--;
            output.append("\n");
        }
        output.append("  ");

        int aValue = Character.getNumericValue('A');
        for(int i = 0; i < board.length; i++){
            output.append((char) (65 + i));
            output.append("   ");
        }


        return output.toString();
    }

    /*
    public enum Coordinate{
        A(0),
        B(1),
        C(2),
        D(3),
        E(4),
        F(5),
        G(6),
        H(7);

        Coordinate(int index) {
            this.index = index;
        }

        final int index;
    }*/
}
