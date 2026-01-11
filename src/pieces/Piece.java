package pieces;
import mechanics.*;

public abstract class Piece {
    public final boolean isWhite;
    public final String representation;
    protected Coordinate position;

    public Piece(String representation, Coordinate position, boolean isWhite){
        this.representation = representation;
        this.isWhite = isWhite;
        this.position = position;
    }

    /**
     * @return a 64 element array of possible move coordinates
     */
    abstract public Coordinate[] getPossibleMoves(Board board);

    /**
     * Moves the piece on the board to the given space
     *
     * @param coordinate
     */
    abstract public void move(Coordinate coordinate);

    @Override
    public String toString(){
        return representation;
    }



}
