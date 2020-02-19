package pl.patrycja.radziej.saper;

import java.util.Scanner;

public class SaperMain {
    public static void main(String[] args) {
        PlayerBoard playerBoard = new PlayerBoard();
        Scanner scanner = new Scanner(System.in);
        boolean play = false;
        while (!play) {
            System.out.println("Które pole odkryć? Podaj wiersz i kolumnę(od 0 do 7)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            System.out.println("-------------------------");
            System.out.println("Wybierz operację: \n1. Odkryj pole \n2. Oznacz bombę");
            int choose = scanner.nextInt();

            if (choose == 1) {
                String field = playerBoard.fillBoardField(row, col);
                if (field.equals("B")) {
                    System.out.println("Game Over");
                    playerBoard.printSaperBoard();
                    break;
                } else {
                    playerBoard.game();
                    System.out.println("-----------------------");

                }
            } else {
                playerBoard.markBomb(row, col);
            }
            play = playerBoard.playFinish();
        }
        if (playerBoard.playFinish()) {
            System.out.println("You win!");
        }
    }
}
