
public abstract class Piece {

    public int x,y; // to indicate the position on board
    protected String letter; // to indicate what letter to display on board
    public String filename;
    public Colour c;// Colour of piece
    private Type t;

    //public String letter;


    public Piece(int x, int y, Colour c){ // constructor

        this.x = x;
        this.y = y;
        this.c = c;

        if(this instanceof pawn && c == Colour.BLACK){
            letter = "P";
            filename = "resources/Pawn_black.png";
        }
        else if(this instanceof pawn && c == Colour.WHITE){
            letter = "P";
            filename = "resources/Pawn_white.png";
        }
        else if(this instanceof bishop && c == Colour.WHITE){
            letter = "B";
            filename = "resources/Bishop_white.png";
        }
        else if(this instanceof bishop && c == Colour.BLACK){
            letter = "B";
            filename = "resources/Bishop_black.png";
        }
        else if(this instanceof rook && c == Colour.BLACK){
            letter = "R";
            filename = "resources/Rook_black.png";
        }
        else if(this instanceof rook && c == Colour.WHITE){
            letter = "R";
            filename = "resources/Rook_white.png";
        }
        else if(this instanceof knight && c == Colour.BLACK){
            letter = "H";
            filename = "resources/Knight_black.png";
        }
        else if(this instanceof knight && c == Colour.WHITE){
            letter = "H";
            filename = "resources/Knight_white.png";
        }
        else if(this instanceof queen && c == Colour.BLACK){
            letter = "Q";
            filename = "resources/Queen_black.png";
        }
        else if(this instanceof queen && c == Colour.WHITE){
            letter = "Q";
            filename = "resources/Queen_white.png";
        }
        else if(this instanceof king && c == Colour.BLACK){
            letter = "K";
            filename = "resources/King_black.png";
        }
        else if(this instanceof king && c == Colour.WHITE){
            letter = "K";
            filename = "resources/King_white.png";
        }
        else
        {
            letter = "empty";
            filename = "";
        }



    }
    public boolean isLegal(int x, int y){
        System.out.println("isLegal of Piece class running");
        return true;
    }

}
