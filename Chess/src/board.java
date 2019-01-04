import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class board {

    // board is an array of pieces
    public ArrayList<Piece> board = new ArrayList<>();

    public board()
    {

        for (int y = 0; y < 8; y++) {

                if(y==0){
                    board.add(new rook(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new rook(0,y,Colour.BLACK));

                }
                if(y==1){

                    board.add(new knight(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new knight(0,y,Colour.BLACK));
                }
                if(y==2){

                    board.add(new bishop(7,y,Colour.WHITE) );
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new bishop(0,y,Colour.BLACK));
                }
                if(y==3){

                    board.add(new queen(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new king(0,y,Colour.BLACK));
                }
                if(y==4){

                    board.add(new king(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new queen(0,y,Colour.BLACK));
                }
                if(y==5){

                    board.add(new bishop(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new bishop(0,y,Colour.BLACK));
                }
                if(y==6){

                    board.add(new knight(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new knight(0,y,Colour.BLACK));
                }
                if(y==7){

                    board.add(new rook(7,y,Colour.WHITE)) ;
                    board.add(new pawn(6,y,Colour.WHITE));
                    board.add(new pawn(1,y,Colour.BLACK));
                    board.add(new rook(0,y,Colour.BLACK));
                }
        }
        for (int x = 2; x < 6; x++) {// 0-7
            for (int y = 0; y < 8; y++) {// 2-4
                board.add(new empty(x,y,Colour.NONE));

            }
        }
    }


    public void swapPieces(int index1, int index2){ // IP from Index from Position function

        int temp1 = board.get(index1).x;
        int temp2 = board.get(index1).y;

        if(board.get(index2) instanceof empty){

            board.get(index1).x = board.get(index2).x;
            board.get(index1).y = board.get(index2).y;
            board.get(index2).x = temp1;
            board.get(index2).y = temp2;
            System.out.println("finished swapping the Pieces");
        }
        else if(board.get(index2).c != board.get(index1).c){
             // position will vary, but index of end piece will stay the same.
            board.get(index1).x = board.get(index2).x;
            board.get(index1).y = board.get(index2).y;
            board.remove(index2);
            board.add(new empty(temp1, temp2, Colour.NONE));
        }
        else
            System.out.println("Same color cannot capture!");
    }


}
