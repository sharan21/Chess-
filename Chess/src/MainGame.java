import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

public class MainGame extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Chess");
    JButton reset = new JButton("Reset");
    JButton[][] squares = new JButton[8][8]; // 8X8 board
    final int size = 8;
    int whoseTurn = 0; // WHITE moves in even turn values
    public board CurrentBoard = new board();

    Container grid = new Container();

    ArrayList<Integer> Buffer = new ArrayList<Integer>();


    public MainGame(){

        setSquares();
        setFrame();
        updateBoard();
    }

    public void updateBoard(){ // to be fixed

        /* takes the PIECES ARRAY as input and places on the SQUARES, if PIECE
        is present, other wish NULL
         */
        for (int i = 0; i < 64; i++) { // for 64 squares

                if(CurrentBoard.board.get(i) instanceof empty) {

                    squares[CurrentBoard.board.get(i).x][CurrentBoard.board.get(i).y].setIcon(null);
                    //squares[CurrentBoard.board.get(i).x][CurrentBoard.board.get(i).y].setText("");
                }
                else
                    //squares[CurrentBoard.board.get(i).x][CurrentBoard.board.get(i).y].setIcon(new ImageIcon(CurrentBoard.board.get(i).filename));
                    squares[CurrentBoard.board.get(i).x][CurrentBoard.board.get(i).y].setIcon(new ImageIcon(getClass().getResource(CurrentBoard.board.get(i).filename)));
                    //squares[CurrentBoard.board.get(i).x][CurrentBoard.board.get(i).y].setText(CurrentBoard.board.get(i).letter); // MIRROR BETWEEN SQUARE AND BOARD **

        }
    }




    public void setSquares(){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i%2==0&&j%2==0||i%2==1&&j%2==1){//black
                    squares[i][j] = new JButton();
                    squares[i][j].addActionListener(this);
                    squares[i][j].setBackground(Color.BLACK);
                    squares[i][j].setContentAreaFilled(true);
                    squares[i][j].setOpaque(true);
                }
                else {
                    squares[i][j] = new JButton();
                    squares[i][j].addActionListener(this);
                }
                //status[i][j] = 0;
                grid.add(squares[i][j]);
            }

        }
    }

    public int getIndexFromPosition(int a, int b)
    {   int index = 0;
        for (int i = 0; i < 65; i++) {
            if(CurrentBoard.board.get(i).x==a && CurrentBoard.board.get(i).y == b){
                index = i;
                break;
            }
        }
        return index;
    }

    public void setFrame(){

        grid.setLayout(new GridLayout(8,8));
        reset.addActionListener(this);

        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.add(grid, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setFocusable(true);
        frame.add(reset, BorderLayout.NORTH);

    }

    public static void main(String args[]){
            new MainGame();
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        for(int x=0;x<squares.length;x++){
            for(int y=0;y<squares[0].length;y++){
                if(actionEvent.getSource().equals(squares[x][y])){ // Checking if button has been pressed
                    System.out.println(x+" was pressed");
                    System.out.println(y+" was pressed");
                    System.out.println("adding to buffer..");
                    addToBuffer(x,y);
                    checkForSwap();

                    try {
                        checkTurn();
                    }
                        catch (IndexOutOfBoundsException e)
                        {
                        // do nothing

                    }

                }
            }
        }
        if(actionEvent.getSource().equals(reset)){
            CurrentBoard = new board();
            whoseTurn = 0;
            updateBoard();
        }
    }

    public void addToBuffer(int x, int y){
            Buffer.add(x);
            Buffer.add(y);
            System.out.println(Buffer);
    }
    public boolean LegalMove(){// only run in Checkforswap, yet to be completed.
        boolean LegalMove = true;
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof knight)
        {
           LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
           System.out.println("LegalMove: "+LegalMove);
        }
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof bishop)
        {
            LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
            System.out.println("LegalMove: "+LegalMove);
        }
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof rook)
        {
            LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
            System.out.println("LegalMove: "+LegalMove);

        }
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof pawn)
        {
            LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
            System.out.println("LegalMove: "+LegalMove);

        }
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof queen)
        {
            LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
            System.out.println("LegalMove: "+LegalMove);

        }
        if(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))) instanceof king)
        {
            LegalMove = CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).isLegal(Buffer.get(2),Buffer.get(3));
            System.out.println("LegalMove: "+LegalMove);
        }
        return LegalMove;
    }
    public void checkForSwap(){

        if(Buffer.size()==4 && LegalMove()){ // has 4 elements, needs to swap
             // check the legality of the move
            System.out.println(getIndexFromPosition(Buffer.get(0),Buffer.get(1)));
            System.out.println(getIndexFromPosition(Buffer.get(2),Buffer.get(3)));
            System.out.println("are the two indexes of the Pieces, in the selected squares");

            CurrentBoard.swapPieces(getIndexFromPosition(Buffer.get(0),Buffer.get(1)),getIndexFromPosition(Buffer.get(2),Buffer.get(3)));

            Buffer.clear();
            whoseTurn++;
            updateBoard();
        }
        else if(Buffer.size()==4 && !LegalMove()){

            Buffer.clear();
            System.out.println("is not legal move ");
        }
    }
    public boolean checkTurn(){
        boolean checkTurn = true;
        if((CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).c == Colour.WHITE && whoseTurn%2 == 1)||(CurrentBoard.board.get(getIndexFromPosition(Buffer.get(0),Buffer.get(1))).c == Colour.BLACK && whoseTurn%2 == 0))
        {
            checkTurn = false;
            System.out.println("Not your move!");
            Buffer.clear();
        }

        return checkTurn;
    }



}


