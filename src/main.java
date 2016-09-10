/**
 * Created by austinberard on 9/10/16.
 */
public class main {
    public static void main(String[] args) throws InterruptedException{
        boolean[][] board = {{false, false, false, false, false},
                             {false, false, true, false, false},
                             {false, false, true, false, false},
                             {false, false, true, false, false},
                             {false, false, false, false, false},
                             };
        TorusBoard gameBoard = new TorusBoard(board);
        int FRAMES = 10;
        while(FRAMES > 0){
            printBoard(gameBoard);
            GameLogic.run(gameBoard);
            FRAMES -= 1;
            Thread.sleep(1000);
        }
    }

    public static void printBoard(TorusBoard board){
        for (int i = 0; i < 50; ++i) System.out.println(); //clears screen...kinda TODO do this better
        boolean[][] curr = board.getCurrentBoard();
        for(int i = 0; i < curr.length; i++){
            for(int j = 0; j< curr[i].length; j++){
                if(board.isAlive(i, j)){
                    System.out.print("*");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
