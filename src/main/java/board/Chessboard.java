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

    public Square getSquare(int row, int column){
        char myColumn;
        row = 7 - row; //again, accounts for the inconsistency between the grid pane and the original logic code
        switch(column){

            case 0:
                myColumn = 'a';
                break;

            case 1:
                myColumn = 'b';
                break;

            case 2: myColumn = 'c';
            break;

            case 3: myColumn = 'd';
                break;

            case 4: myColumn = 'e';
                break;

            case 5: myColumn = 'f';
                break;

            case 6: myColumn = 'g';
                break;

            default: myColumn = 'h';
        }
        return new Square(Map.entry(myColumn, row+1));

    }
}

