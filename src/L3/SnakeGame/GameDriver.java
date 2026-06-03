package L3.SnakeGame;

import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        boolean isGameAlive = true;
        Snake snake = new Snake();
        //GROUND DIMENSIONS
        Ground ground = new Ground(8,8);
        Scanner sc = new Scanner(System.in);
        int row =0;
        int col =0;
        while(isGameAlive){
            if(snake.getSnake().isEmpty()){
                ground.setNextFood();
                snake.move(row,col,ground);
                continue;
            }
            System.out.println("Enter your next Move (U,D,L,R)");
            char move = sc.next().charAt(0);
            if(move=='U') snake.move(--row,col,ground);
            else if(move=='D') snake.move(++row,col,ground);
            else if(move =='R')snake.move(row,++col,ground);
            else if(move=='L') snake.move(row,--col,ground);
            else {
                System.out.println("Invalid Move");
                isGameAlive = false;
            }
        }
    }
}
