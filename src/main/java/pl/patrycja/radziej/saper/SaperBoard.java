package pl.patrycja.radziej.saper;

import java.util.Random;

public class SaperBoard {
    private String[][] board = new String[8][8];
    private int bombLeft = 10;

    public SaperBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "_";
            }
        }
        Random random = new Random();
        while (bombLeft>0){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int bomb = random.nextInt(10);
                    if(bomb>8 && !board[i][j].equals("B") && bombLeft>0){
                        board[i][j]="B";
                        --bombLeft;
                    }
                    if (i==7 && j==7 && bombLeft>0){
                        i=0;
                        j=0;
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!getFieldStatus(i, j).equals("B")) {
                    int counter = 0;
                    if ((0 < i && i < 7) && (0 < j && j < 7)) {
                        if (getFieldStatus(i - 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if ((0 == i) && (0 < j && j < 7)) {
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if ((0 < i && i < 7) && (j == 0)) {
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if ((7 == i) && (0 < j && j < 7)) {
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if ((0 < i && i < 7) && (j == 7)) {
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if (j == 0 && i == 0) {
                        if (getFieldStatus(i + 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if (i == 7 && j == 0) {
                        if (getFieldStatus(i - 1, j + 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i, j + 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if (i == 0 && j == 7) {
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i + 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    } else if (j == 7 && i == 7) {
                        if (getFieldStatus(i, j - 1).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j).equals("B")) {
                            counter++;
                        }
                        if (getFieldStatus(i - 1, j - 1).equals("B")) {
                            counter++;
                        }
                        if (counter > 0) {
                            board[i][j] = String.valueOf(counter);
                        } else {
                            board[i][j] = " ";
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public String getFieldStatus(int row, int col) {
        return board[row][col];
    }


    public void action(int row, int col) {
        if (board[row][col].equals("B")){
            throw new IllegalStateException("Game Over");
        }
    }
}
