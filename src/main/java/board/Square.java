package board;

import java.util.HashMap;
import java.util.Map;


public class Square {
    Map.Entry<Character, Integer> position;
    HashMap<Square, Position> positionToSquare;

    public Square(Map.Entry<Character, Integer> position){
        this.position = position;
    }


    public Map.Entry<Character, Integer> getPosition() {
        return position;
    }



    public Character getKey() {
        return position.getKey();
    }

    public Integer getValue() {
        return position.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getKey();
        result = prime * result + getValue();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        return getKey() == other.getKey() && getValue() == other.getValue();
    }
}
