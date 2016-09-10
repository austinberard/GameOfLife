/**
 * Created by austinberard on 9/10/16.
 */
public class GameLogic {

    public static void run(TorusBoard board){
        //TODO
        //change values of nextboard based on current board using changeNextBoard
        //then when done update the board
        //print the currentboard(which is now updated) to the console or w/e
        updateBoard(board);

    }

    private static int getNumberOFNeighbours(TorusBoard board, int row, int column){
        int neighbours = 0;
        int maxCol = board.getWidth() - 1;
        int maxRow = board.getHeight() - 1;

        //up
        //if its on top row
        if(row == 0){
            if(board.isAlive(maxRow, column)) {
                neighbours += 1;
            }
        }
        else{
            if(board.isAlive(row - 1, column)){
                neighbours += 1;
            }
        }

        //down
        //if its on bottom row
        if(row == maxRow) {
            if(board.isAlive(0, column)){
                neighbours += 1;
            }
        }
        else {
            if(board.isAlive(row + 1, column)){
                neighbours += 1;
            }
        }

        //left
        //if its in column 0
        if(column == 0){
            if(board.isAlive(row, maxCol)){
                neighbours += 1;
            }
        }
        else {
            if(board.isAlive(row, column - 1)){
                neighbours += 1;
            }
        }

        //right
        //if its at far right
        if(column == maxCol) {
            if(board.isAlive(row, 0)){
                neighbours += 1;
            }
        }
        else {
            if(board.isAlive(row, column + 1)){
                neighbours += 1;
            }
        }

        //diag left up
        //Are we in top left corner?
        if( row == 0 && column == 0 ){
            //then we want to chekc bottom right
            if(board.isAlive(maxRow, maxCol)){
                neighbours += 1;
            }
        }
        //are we on the top of the grid
        else if(row == 0){
            //then we want to go to the bottom row and over one to the left
            if(board.isAlive(maxRow, column - 1)){
                neighbours += 1;
            }
        }
        //are we on the left side of the grid
        else if( column == 0){
            //then we want to go to the far right and up one
            if(board.isAlive(row - 1, maxCol)){
                neighbours += 1;
            }
        }
        //are on a normal position
        else{
            if(board.isAlive(row - 1, column - 1)){
                neighbours += 1;
            }
        }

        //diag right up
        //check if we are at top right
        if(row == 0 && column == maxCol){
            //then we want to check bottom left
            if(board.isAlive(maxRow, 0)){
                neighbours += 1;
            }
        }
        //check if we are on top edge
        else if(row == 0){
            //then we want to check bottom row and col + 1
            if(board.isAlive(maxRow, column + 1)){
                neighbours += 1;
            }
        }
        //check if we are on far right edge
        else if(column == maxCol){
            //we want to chekc row - 1 and col at 0
            if(board.isAlive(row - 1, 0)){
                neighbours += 1;
            }
        }
        //it must be normal
        else{
            //want to chekc row -1 and col + 1
            if(board.isAlive(row - 1, column + 1)){
                neighbours += 1;
            }
        }

        //diag down left row + 1 col - 1
        //check if we are at bottom left corner
        if(row == maxRow && column == 0){
            //then we want to check top right
            if(board.isAlive(0, maxCol)){
                neighbours += 1;
            }
        }
        //check if its on the bottom row
        else if(row == maxRow){
            //we want to got to row 0 and col - 1
            if(board.isAlive(0, column - 1)){
                neighbours += 1;
            }
        }
        //check if its on left side
        else if(column == 0){
            //then we want to check row + 1 and maxCol
            if(board.isAlive(row + 1, maxCol)){
                neighbours += 1;
            }
        }
        //then it must be normal
        else{
            // check row + 1 col - 1
            if(board.isAlive(row + 1, column - 1)){
                neighbours += 1;
            }
        }

        //diag down right row + 1 col + 1
        //check if we are in bottom right
        if(row == maxRow && column == maxCol){
            //we want to check top left
            if(board.isAlive(0,0)){
                neighbours += 1;
            }
        }
        //check if its on the bottom row
        else if(row == maxRow){
            //we want row = 0  and col + 1
            if(board.isAlive(0, column + 1)){
                neighbours += 1;
            }
        }
        //check if its on the right side
        else if(column == maxCol){
            //check row + 1 col = 0
            if(board.isAlive(row + 1, 0)){
                neighbours += 1;
            }
        }
        //normal
        else{
            //want to check row + 1 col + 1
            if(board.isAlive(row + 1, column + 1)){
                neighbours += 1;
            }
        }

        return neighbours;
    }

    private static void updateBoard(TorusBoard board){
        for(int i = 0; i < board.getCurrentBoard().length; i++){
            for(int j = 0; j < board.getCurrentBoard()[i].length; j++){
                int neighbours = getNumberOFNeighbours(board, i, j);

                //If the cell is alive
                if(board.getCurrentBoard()[i][j]){
                    if(neighbours < 2 || neighbours > 3){
                        board.changeNextBoard(i, j, false);
                    }
                    else{
                        board.changeNextBoard(i, j, true);
                    }
                }
                else{
                    if(neighbours == 3){
                        board.changeNextBoard(i, j, true);
                    }
                }

            }
        }
        board.update();
    }
}
