package L3.SnakeGame;

import java.util.Scanner;

public class Ground {
    private final int noOfRows;
    private final int noOfCols;
    private final char[][] ground ;
    private Node[] foodArray;
    private int foodArrayPtr;
    public Ground(int noOfRows, int noOfCols) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.ground = new char[noOfRows][noOfCols];
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfCols;j++){
                ground[i][j]='_';
            }
        }
        //foodArray Logic
//        System.out.println("Enter the No of Foods you want");
//        Scanner sc = new Scanner(System.in);
//        int noOfFoods = sc.nextInt();
//        foodArray = new Node[noOfFoods];
//        for(int i=0;i<noOfFoods;i++){
//            System.out.println("Enter the row and col position of the food");
//            int row = sc.nextInt();
//            int col = sc.nextInt();
//            foodArray[foodArrayPtr++]=new Node(row,col);
//        }
        foodArray = new Node[]{new Node(2,2),new Node(3,3),new Node(4,4)};
        foodArrayPtr = 0;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfCols() {
        return noOfCols;
    }

    public void setGround(int row,int col,char val){
        ground[row][col]=val;
    }

    public char getGroundValue(int row,int col) {
        if(isValidMove(row,col))
        return ground[row][col];
        else {
            System.out.println("Invalid Index");
            System.exit(0);
        }
        return '\0';
    }

    public void displayGround(){
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfCols;j++){
                System.out.print(ground[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row,int col){
        return ((row>=0 && row<this.noOfRows) && (col>=0 && col<this.noOfCols));
    }

    public void setNextFood(){
        if(foodArrayPtr<foodArray.length){
            setGround(foodArray[foodArrayPtr].getRow(),foodArray[foodArrayPtr++].getCol(),'F');
        }
        else {
           return;
        }
    }
}
