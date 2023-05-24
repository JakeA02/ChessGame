package pieces;

import board.OccupiedSquares;
import board.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    private Rook rook;
    private Bishop bishop;

    public Queen (Square position, PieceColor color) {
        super(position, color);

        rook = new Rook (position, color);
        bishop = new Bishop(position, color);
    }

    @Override
    public boolean isValidMove(Square move) {
        return rook.isValidMove(move) || bishop.isValidMove(move);
    }

    @Override
    public List<Square> getAvailableMoves() {
        List<Square> moves = new ArrayList<>();

        moves.addAll(getHorizontalMoves());
        moves.addAll(getVerticalMoves());
        moves.addAll(getDiagonalMoves());

        return moves;
    }

    @Override
    public List<Square> getDiagonalMoves() {
        return bishop.getDiagonalMoves();
    }

    @Override
    public void setColor(PieceColor color) {
        this.color = color;
    }

    @Override
    public List<Square> getHorizontalMoves() {
        return rook.getHorizontalMoves();
    }

    @Override
    public List<Square> getVerticalMoves() {
        return rook.getVerticalMoves();
    }

    @Override
    public void setPosition(Square position, Piece piece) {

        if(currentPosition != null){
            OccupiedSquares.removeOccupiedSquare(currentPosition);
        }
        this.currentPosition = position;
        if(bishop != null && rook != null) {
            bishop.setPosition(currentPosition, bishop);
            rook.setPosition(currentPosition, rook);
        }
        OccupiedSquares.addOccupiedSquare(position, piece);

    }
    @Override
    public PieceColor getColor() {
        return this.color;
    }

    @Override
    public Square getPosition() {
        return currentPosition;
    }

    @Override
    public void outputAvailableMoves() {
        System.out.println("Queen moves: ");
        List<Square> moves = new ArrayList<>(getAvailableMoves());

        for (Square move : moves) {
            System.out.print(move.getKey().toString() + move.getValue() + " ");
        }
        System.out.println(" ");
    }


}

