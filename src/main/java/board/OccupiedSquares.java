package board;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import pieces.PieceColor;
import pieces.Piece;

import java.util.Arrays;
import java.util.Hashtable;

public class OccupiedSquares extends Chessboard {
    public static ListMultimap < Character, Integer > occupiedSquares;
    public static Hashtable <Square, Piece > pieceOccupation;
    public Chessboard chessboard;

    public OccupiedSquares() {

        occupiedSquares = ArrayListMultimap.create();
        pieceOccupation = new Hashtable<>();
        chessboard = new Chessboard();
    }

    public static void addOccupiedSquare(Square square, Piece piece) {
        occupiedSquares.put(square.getKey(), square.getValue());
        pieceOccupation.put(square, piece);



    }
    public static PieceColor getOccupantColor(Square square) {
        return pieceOccupation.get(square).getColor();
    }


    public static boolean isOccupied(Square square) {
        return occupiedSquares.containsEntry(square.getKey(), square.getValue());
    }

    public ListMultimap < Character, Integer > getOccupiedSquares() {
        return occupiedSquares;
    }

    public void outputOccupiedSquares() {
        for (char i = 'a'; i < 'h'; i++) {
            System.out.println(i + ":");
            System.out.println(Arrays.toString(occupiedSquares.get(i).toArray()));
        }

    }



    public static void removeOccupiedSquare(Square square) {
        occupiedSquares.remove(square.getKey(), square.getValue());
    }
}