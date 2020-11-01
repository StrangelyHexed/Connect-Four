public class ConnectFour {


    // Data Fields //
    private static final int col = 7;
    private static final int row = 6;
    private final char[][] board;


    // Initializing Constructor - Build Board //
    public ConnectFour(){
        this.board = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                this.board[i][j] = ' ';
            }
        }
    }


    // Accessor //
    public char[][] getBoard() {return this.board;}


    // Method To Print The Board //
    public void printBoard(){
        System.out.println();
        for(int i = 0; i < row; i++){
            System.out.print(" |");
            for(int j = 0; j < col; j++){
                System.out.print(" " + this.board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }


    //Method To Drop Pieces //
    public boolean dropPieces(char piece, int dropCol) {
        if ((dropCol < 0) || (dropCol > 6)) {
            System.out.println("Incorrect column value. Please enter a valid column number.");
            return false;
        }

        if (board[0][dropCol] != ' ') {
            System.out.println("Column is full. Try a different column number.");
        }

        if (dropCol >= 0 && dropCol <= 6) {
            for (int i = this.board.length - 1; i >= 0; i--) {
                if (this.board[i][dropCol] == ' ') {
                    this.board[i][dropCol] = piece;
                    return true;
                }
            }
        }

        else {System.out.println("Incorrect input. Please enter a valid column number.");}

        return false;
    }


    // Check For a Win //
    public boolean checkWin(){
        for (int i = 0; i < 7 ; i++){
            for (int j = 0; j < 3; j++){
                if (this.board[j][i] != ' '){
                    if (this.board[j][i] == this.board[j+1][i] && this.board[j][i] == this.board[j+2][i] && this.board[j][i] == this.board[j+3][i]){
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < 6 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                if(this.board[i][j] != ' '){
                    if (this.board[i][j] == this.board[i][j+1] && this.board[i][j] == this.board[i][j+2] && this.board[i][j] == this.board[i][j+3]){
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4 ; j++){
                if (this.board[i][j] != ' '){
                    if(this.board[i][j] == this.board[i+1][j+1] && this.board[i][j] == this.board[i+2][j+2] && this.board[i][j] == this.board[i+3][j+3]){
                        return true;
                    }
                }
            }
        }

        for (int i = 5; i > 2 ; i--){
            for (int j = 0;  j < 4; j++){
                if(this.board[i][j] != ' '){
                    if (this.board[i][j] == this.board[i-1][j+1] && this.board[i][j] == this.board[i-2][j+2] && this.board[i][j] == this.board[i-3][j+3]){
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
