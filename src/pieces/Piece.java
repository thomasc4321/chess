package pieces;
import mechanics.*;

public abstract class Piece {
    public final boolean isWhite;
    public final String representation;
    protected Coordinate position;
    protected final Board board;

    public Piece(Board board, String representation, Coordinate position, boolean isWhite){
        this.board = board;
        this.representation = representation;
        this.isWhite = isWhite;
        this.position = position;
    }

    /**
     * @return a 64 element array of possible move coordinates
     */
    abstract public Coordinate[] getPossibleMoves();

    /**
     * Moves the piece on the board to the given space
     * Intended external function to move a piece, calls Board from here
     * @param newCoordinate
     */
    public void move(Coordinate newCoordinate){
        board.movePiece(this, newCoordinate);
        position = newCoordinate;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return representation;
    }
}
