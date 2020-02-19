package pl.patrycja.radziej.saper;

import java.util.Scanner;

public class PlayerBoard {
    String [][] playerBoard = new String [8][8];
    SaperBoard board = new SaperBoard();
    int bombLeft = 10;

    public int getBombLeft() {
        return bombLeft;
    }

    public void setBombLeft(int bombLeft) {
        this.bombLeft = bombLeft;
    }

    public PlayerBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                playerBoard[i][j] = "_";
            }
        }
    }

    public void game(){
        System.out.println("   0 1 2 3 4 5 6 7");
        for (int i = 0; i <8 ; i++) {
            System.out.print(i+" |");
            for (int j = 0; j <8 ; j++) {
                System.out.print(playerBoard[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("Pozostało bomb: "+ bombLeft);
    }

    public String checkField(int row, int col){
        if(playerBoard[row][col].equals("_")) {
            String field = board.getFieldStatus(row, col);
            if (field.equals(" ")) {
                return fillBoardField(row, col);
            }
            return playerBoard[row][col] = board.getFieldStatus(row, col);
        }
        return playerBoard[row][col];
    }

    public String fillBoardField (int row, int col){
        if (playerBoard[row][col].equals("_")) {
            if (board.getFieldStatus(row, col).equals(" ")) {
                playerBoard[row][col] = board.getFieldStatus(row, col);
                if ((0 < col && col < 7) && (0 < row && row < 7)) {
                    checkField(row - 1, col - 1);
                    checkField(row - 1, col);
                    checkField(row - 1, col + 1);
                    checkField(row, col - 1);
                    checkField(row, col + 1);
                    checkField(row + 1, col + 1);
                    checkField(row + 1, col - 1);
                    checkField(row + 1, col);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if ((0 == row) && (0 < col && col < 7)) {
                    checkField(row, col - 1);
                    checkField(row, col + 1);
                    checkField(row + 1, col + 1);
                    checkField(row + 1, col - 1);
                    checkField(row + 1, col);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if ((0 < row && row < 7) && (col == 0)) {
                    checkField(row - 1, col);
                    checkField(row + 1, col + 1);
                    checkField(row + 1, col);
                    checkField(row - 1, col + 1);
                    checkField(row, col + 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if ((7 == row) && (0 < col && col < 7)) {
                    checkField(row, col - 1);
                    checkField(row, col + 1);
                    checkField(row - 1, col + 1);
                    checkField(row - 1, col - 1);
                    checkField(row - 1, col);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if ((0 < row && row < 7) && (col == 7)) {
                    checkField(row - 1, col);
                    checkField(row + 1, col - 1);
                    checkField(row + 1, col);
                    checkField(row - 1, col - 1);
                    checkField(row, col - 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if (col == 0 && row == 0) {
                    checkField(row + 1, col + 1);
                    checkField(row + 1, col);
                    checkField(row, col + 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if (row == 7 && col == 0) {
                    checkField(row - 1, col + 1);
                    checkField(row - 1, col);
                    checkField(row, col + 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if (row == 0 && col == 7) {
                    checkField(row, col - 1);
                    checkField(row + 1, col);
                    checkField(row + 1, col - 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                } else if (col == 7 && row == 7) {
                    checkField(row, col - 1);
                    checkField(row - 1, col);
                    checkField(row - 1, col - 1);
                    return playerBoard[row][col] = board.getFieldStatus(row, col);
                }
            }
        } else if (playerBoard[row][col].equals("P")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pole oznaczone bomba. Czy zmienić?\n1.Tak\n2.Nie");
            int result = scanner.nextInt();
            if(result==1){
                playerBoard[row][col]="_";
                bombLeft++;
                fillBoardField(row,col);
            } else {
                return playerBoard[row][col]="P";
            }
        }
        return playerBoard[row][col]=board.getFieldStatus(row, col);
    }
    public void markBomb(int row, int col) {
        playerBoard[row][col]="P";
        bombLeft = bombLeft -1;
        game();
    }
    public void printSaperBoard(){
        board.print();
    }


    public static void main(String[] args) {
        PlayerBoard playerBoard = new PlayerBoard();
        playerBoard.game();
    }

    public boolean playFinish(){
        int counter=0;
        if(bombLeft==0){
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <8 ; j++) {
                    if(playerBoard[i][j]==board.getFieldStatus(i,j)){
                        counter++;
                    } else if (playerBoard[i][j].equals("P") && board.getFieldStatus(i,j).equals("B")){
                        counter++;
                    }
                }
            }
        }
        if (counter==64){
            return true;
        }
        return false;
    }
}
