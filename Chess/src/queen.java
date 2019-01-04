public class queen extends Piece {

    public int x,y;
    //public String letter = "Q";
    public Colour c;

    public queen(int x, int y, Colour c){
        super(x,y,c);

    }
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaY = Math.abs(y - super.y), deltaX = Math.abs(x - super.x);
        boolean isLegal = deltaY == 0 || deltaX == 0 || deltaX == deltaY;

        return isLegal;
    }


}
