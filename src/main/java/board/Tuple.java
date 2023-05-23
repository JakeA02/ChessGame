package board;
import java.util.ArrayList;


public class Tuple {

        private int row;
        private int column;

        public Tuple(int column, int row) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

