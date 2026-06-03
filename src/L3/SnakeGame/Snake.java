package L3.SnakeGame;

import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private Queue<Node> snake;

    public Snake() {
        this.snake = new LinkedList<>();
    }

    public Queue<Node> getSnake() {
        return snake;
    }

    public void move(int nextRow,int nextCol,Ground ground){
//        System.out.println("Current Move"+nextRow+" "+nextCol);
        if(!ground.isValidMove(nextRow,nextCol)){
            System.out.println(ground.isValidMove(nextRow,nextCol));
            System.out.println("Invalid Move ");
            System.out.println("GAME OVER");
            System.exit(0);
            return;
        }
        if(ground.getGroundValue(nextRow,nextCol)=='*'){
            System.out.println("Snake Bitten Itself");
            System.out.println("GAME OVER");
            System.exit(0);
            return;
        }
        if(ground.getGroundValue(nextRow,nextCol)=='F'){
            ground.setGround(nextRow,nextCol,'*');
            this.getSnake().add(new Node(nextRow,nextCol));
//            snake.add(new Node(nextRow,nextCol));
            ground.setNextFood();
            ground.displayGround();
            return;
        }

        Node lastNode = snake.poll();
        if(lastNode!=null){
            int lastRow = lastNode.getRow();
            int lastCol = lastNode.getCol();
            System.out.println("Last Row Col is "+lastRow+" "+lastCol);
            System.out.println("next row col is"+nextRow+" "+nextCol);
            ground.setGround(lastRow,lastCol,'_');
            ground.setGround(nextRow,nextCol,'*');
            this.getSnake().add(new Node(nextRow,nextCol));
        }else {
            ground.setGround(0,0,'*');
            this.getSnake().add(new Node(nextRow,nextCol));
        }
        ground.displayGround();
    }
}
