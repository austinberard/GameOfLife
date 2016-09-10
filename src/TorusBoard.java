/**
 * Created by austinberard on 9/10/16.
 */
public class TorusBoard {
    private int WIDTH;
    private int HEIGHT;
    private boolean[][] currentBoard;
    private boolean[][] nextBoard;

    public TorusBoard(boolean[][] board){
        this.WIDTH = board[0].length;
        this.HEIGHT = board.length;
        this.currentBoard = board;
        nextBoard = board;
    }

    public TorusBoard(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        currentBoard = new boolean[HEIGHT][WIDTH];

        for(int i = 0; i < currentBoard.length; i++){
            for(int j = 0; j < currentBoard[i].length; j++){
                currentBoard[i][j] = false;
            }
        }
        nextBoard = currentBoard;
    }

    public void changeNextBoard(int row, int column, boolean life){
        nextBoard[row][column] = life;
    }

    public void update(){
        currentBoard = nextBoard;
        nextBoard = currentBoard;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public boolean[][] getCurrentBoard(){
        return currentBoard;
    }

    public boolean isAlive(int row, int col){
        return currentBoard[row][col];
    }


}
