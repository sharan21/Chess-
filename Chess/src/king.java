
public class king extends Piece {

    public int x,y;
    //public String letter = "K";
    public Colour c;

    public king(int x, int y, Colour c){
        super(x,y,c);

    }
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaY = Math.abs(y - super.y), deltaX = Math.abs(x - super.x);
        double distance = Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
        boolean isLegal = (deltaY == 0 || deltaX == 0 || deltaX == deltaY) && distance <= Math.sqrt(2);

        return isLegal;
    }


}
