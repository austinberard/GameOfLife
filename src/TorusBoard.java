/**
 * Created by austinberard on 9/10/16.
 */
public class TorusBoard {
    private int WIDTH;
    private int HEIGHT;
    private boolean[][] currentBoard;
    private boolean[][] nextboard;

    public TorusBoard(int width, int height, boolean[][] board){
        this.WIDTH = width;
        this.HEIGHT = height;
        this.currentBoard = board;
        nextboard = board;
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
        nextboard = currentBoard;
    }

    public void changeNextboard(int row, int column, boolean life){
        currentBoard[row][column] = life;
    }

    public void update(){
        currentBoard = nextboard;
        nextboard = currentBoard;
    }

    public boolean get(int row, int column){
        return currentBoard[row][column];
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


}
