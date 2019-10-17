package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter cells:");

        String input = scanner.nextLine();
        String in = input.replaceAll("\"", "");
        char[][] cells = new char[3][3];
        int cell = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = in.charAt(cell);
                cell++;
            }
        }

        System.out.println("---------");
        System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
        System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
        System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
        System.out.println("---------");

        int x = 0;
        int o = 0;
        boolean possible = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 'X') {
                    x += 1;
                } else if (cells[i][j] == 'O') {
                    o += 1;
                }
            }
        }
        if (Math.abs(x - o) >= 2) {
            possible = false;
        }
        boolean win = false;
        char winnig = 'n';
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2] && winnig == 'n') {
                win = true;
                winnig = cells[i][0];
            } else if (cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2] && winnig != 'n') {
                possible = false;
            }
            if (cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i] && winnig == 'n') {
                win = true;
                winnig = cells[0][i];
            } else if (cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i] && winnig != 'n') {
                possible = false;
            }
        }
        if (cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2] || cells[2][0] == cells[1][1] && cells[2][0] == cells[0][2]) {
            win = true;
            winnig = cells[1][1];
        }

        boolean empty = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    empty = true;
                }
            }
        }
        if (possible) {
            if (win) {
                System.out.println(winnig + " wins");
            } else if (empty) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        } else {
            System.out.println("Impossible");
        }
    }
}
