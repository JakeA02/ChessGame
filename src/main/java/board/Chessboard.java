package board;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Arrays;
import java.util.Map;

public class Chessboard {
    public ListMultimap<Character, Integer> chessboard;


    public Chessboard() {
        chessboard = ArrayListMultimap.create();
        for (char i = 'a'; i < 'i'; i++) {
            for (int j = 1; j < 9; j++) {
                chessboard.put(i, j);
            }
        }
    }

    public Square getSquare(Position position){
        Character column = Character.toLowerCase(position.name().charAt(0));

        Integer row = Integer.parseInt(position.name().substring(1));

        return new Square(Map.entry(column, row));


    }

    public void outputBoard() {
        for (char i = 'a'; i < 'h'; i++) {
            System.out.println(i + ":");
            System.out.println(Arrays.toString(chessboard.get(i).toArray()));
        }
    }
}

