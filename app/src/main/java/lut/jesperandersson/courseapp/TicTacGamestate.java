package lut.jesperandersson.courseapp;

public class TicTacGamestate {
    int[] board;
    public TicTacGamestate(){
        board = new int[9];
    }

    public void makePlayerMove(int i) {
        if (board[i] == 0){
            board[i] = 1;
            makeComputerMove();
        }
    }

    private void makeComputerMove() {
        boolean moveMade = false;
        if (!fullBoard() && getWinner() == 0){
            while (!moveMade){
                int randomNum = (int) Math.floor(Math.random()*9);
                if (board[randomNum] == 0){
                    board[randomNum] = -1;
                    moveMade = true;
                }
            }
        }

    }

    private boolean fullBoard() {
        for (int i: board){
            if (i == 0){
                return false;
            }
        }
        return true;
    }

    public String getGameOverMsg() {
        int winner = getWinner();
        if (winner == 0 && fullBoard()){
            return "Draw!";
        }
        switch (winner){
            case -1: return "CPU wins!";
            case 1: return "YOU win!";
            default: return null;
        }
    }

    private int getWinner() {
        // check cols
        for (int row=0; row<3; row++){
            int i = row * 3;
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                return board[i];
            }
        }
        // check rows
        for (int col=0; col<3; col++){
            if (board[col] == board[col + 3] && board[col + 3] == board[col + 6]) {
                return board[col];
            }
        }
        // check diagonals
        if (board[0] == board[4] && board[4] == board[8]) {
            return board[0];
        }
        if (board[2] == board[4] && board[4] == board[6]) {
            return board[2];
        }
        return 0;
    }
}
