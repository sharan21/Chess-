import java.awt.*;

public class knight extends Piece {

    public int x,y;
    //public String letter = "K";
    public Colour c;

    public knight(int x, int y,Colour c){
        super(x,y,c);

    }
    @Override
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaY = Math.abs(y - super.y), deltaX = Math.abs(x - super.x);
        boolean isLegal = deltaY == 2 && deltaX == 1 || deltaY == 1 && deltaX == 2;
        System.out.println("isLegal of knight class running");
        //return isLegal;
        return isLegal;
    }


}
