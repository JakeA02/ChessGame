package teams;

import board.Square;
import pieces.Piece;

import java.util.List;
import java.util.Set;

public class whiteTeam {

    public Set<Piece> pieces;
    public Set<Square> moves;

    public whiteTeam(Set<Piece> pieces, Set<Square> moves){
        this.pieces = pieces;
        this.moves = moves;
    }
    public void addPiece(Piece piece){
        pieces.add(piece);
    }
    public Set<Piece> getPieces(){
        return pieces;
    }
    public void addMoves(List< Square > list){
        moves.addAll(list);
    }
    public Set<Square> getMoves(){
        return moves;
    }


}
