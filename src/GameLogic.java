import com.sun.corba.se.impl.oa.toa.TOA;

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

    public static int getNumberOFNeighbours(TorusBoard board, int row, int column){
        int neighbours = 0;
        //up
        if(row - 1 < 0){
            if(board.get(board.getHeight() - 1, column)) { //TODO check if '-1' is correct here
                neighbours += 1;
            }
        }
        else{
            if(board.get(row - 1, column)){
                neighbours += 1;
            }
        }

        //down
        if(row + 1 > board.getHeight() - 1) { //TODO check if '-1' is correct here
            if(board.get(0, column)){
                neighbours += 1;
            }
        }
        else {
            if(board.get(row + 1, column)){
                neighbours += 1;
            }
        }

        //left
        if(column - 1 < 0){
            if(board.get(row, board.getWidth() - 1)){ //TODO check if '-1' is correct here
                neighbours += 1;
            }
        }
        else {
            if(board.get(row, column - 1)){
                neighbours += 1;
            }
        }

        //right
        if(column + 1 > board.getWidth() - 1) { //TODO check if '-1' is correct here
            if(board.get(row, 0)){
                neighbours += 1;
            }
        }
        else {
            if(board.get(row, column + 1)){
                neighbours += 1;
            }
        }
        return neighbours;
    }

    public static void updateBoard(TorusBoard board){
        for(int i = 0; i < board.getCurrentBoard().length; i++){
            for(int j = 0; j < board.getCurrentBoard()[i].length; j++){
                int neighbours = getNumberOFNeighbours(board, i, j);

                //If the cell is alive
                if(board.getCurrentBoard()[i][j]){
                    if(neighbours < 2 || neighbours > 3){
                        board.changeNextboard(i, j, false);
                    }
                    else{
                        board.changeNextboard(i, j, true);
                    }
                }
                else{
                    if(neighbours == 3){
                        board.changeNextboard(i, j, true);
                    }
                }

            }
        }
        board.update();
    }
}
