package pieces;

import board.Square;

import java.util.List;

public abstract class Piece {
    protected Square currentPosition;
    protected Color color;



    public Piece(Square position, Color color) {
        setColor(color);
        setPosition(position, this);

    }

    public abstract boolean isValidMove(Square move);

    public abstract List<Square> getAvailableMoves();

    public abstract List<Square> getDiagonalMoves();

    public abstract void setColor(Color color);

    public abstract Color getColor();

    public abstract List<Square> getHorizontalMoves();

    public abstract List<Square> getVerticalMoves();

    public abstract void setPosition(Square position, Piece piece);

    public abstract Square getPosition();

    public abstract void outputAvailableMoves();
}