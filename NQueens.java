public class NQueens {
    private int num;
    private int[][] board;

//    public static void main(String[] args) throws Exception { //my main function to print to console
//        NQueens nq = new NQueens(8);
//
//            if(nq.placeNQueens()) {
//                nq.printToConsole();
//            }
//
//    }


    NQueens(int n) {
        num = n;
        board = new int[num][num];
    }

    //  throws Exception if board size less than 1
    boolean placeNQueens() throws Exception{
        if (num < 1) {
            throw new Exception("Number must be greater than 0");
        }
        if (placeQ(0)) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean placeQ(int row) {
        if (row == num) {
            return true;
        }
        for (int col = 0; col < num; col++) {
            if (!isAttacked(row, col)) { //if it is not attacked then places 1 in space, representing queen
                board[row][col] = 1;
                if (placeQ(row + 1)) { //recursive call
                    return true;
                }
                board[row][col] = 0;//backtracking by making spots that didn't work 0
            }
        }
        return false;
    }
    boolean isAttacked(int r, int c) {
        int i, j;
        for (i = 0; i < num; i++) {//checks all rows in the same column for an attacking queen :1
            if (i!=r&&board[i][c] == 1)
                return true;
        }
        for (i = r, j = c; i >= 0 && j >= 0; i--, j--) {//checks upper left diagonal
            if (i!=r&&j!=c&&board[i][j] == 1)
                return true;
        }
        for (i = r, j = c; i >= 0 && j < num; i--, j++) {//checks upper right diagonal
            if (i!=r&&j!=c&&board[i][j] == 1)
                return true;
        }
        for (i = r, j = c; i < num && j >= 0; i++, j--) {//checks lower left diagonal
            if (i!=r&&j!=c&&board[i][j] == 1)
                return true;
        }
        for (i = r, j = c; i < num && j < num; i++, j++) {//checks upper right diagonal
            if (i!=r&&j!=c&&board[i][j] == 1)
                return true;
        }
        return false;
    }

    void printToConsole() {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println("");
    }
}
