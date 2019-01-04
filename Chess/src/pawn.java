public class pawn extends Piece {

    public int x,y;
    private String letter = "P";
    public Colour c;

    public pawn(int x, int y, Colour c){
        super(x,y,c);

    }
    @Override
    public boolean isLegal(int x, int y) // from avis code
    {
        int deltaX = x - super.x;
        int deltaY = y - super.y;

        boolean isLegal = Math.abs(deltaX) == 1 && deltaY == 0;
        System.out.println("isLegal of pawn class running");
        //return isLegal;
        return isLegal;
    }


}
