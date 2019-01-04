public class bishop extends Piece {

    public int x,y;
    //public String letter = "R";
    public Colour c;

    public bishop(int x, int y, Colour c){
        super(x,y,c);

    }
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaY = Math.abs(y - super.y), deltaX = Math.abs(x - super.x);
        boolean isLegal = deltaY == deltaX;
        return isLegal;

    }

}
