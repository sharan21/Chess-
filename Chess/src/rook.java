public class rook extends Piece {

    public int x,y;
    //public String letter = "R";
    public Colour c;
    private Type t;

    public rook(int x, int y, Colour c){
        super(x,y,c);

    }
    @Override
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaY = Math.abs(y - super.y), deltaX = Math.abs(x - super.x);
        boolean isLegal = deltaY == 0 || deltaX == 0;
        System.out.println("isLegal of knight class running");
        //return isLegal;
        return isLegal;
    }


}
