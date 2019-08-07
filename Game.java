package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {
    public char tic = 'X';
    public char tac = 'O';

    public int[][] field = new int[3][3];
    public boolean isGameOver = false;
    public boolean isFirstPlayerWin = false;
    public boolean isSecondPlayerWin = false;
    public boolean tie = false;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Game() {
        for (int[] row : field)
            Arrays.fill(row, '.');
    }

    public void turn() throws IOException {


        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Game start");
        System.out.println("First player, enter your name:");
        Player player1 = new Player(reader.readLine());
        System.out.println("Second player, enter your name:");
        Player player2 = new Player(reader.readLine());
        while (!isGameOver || !tie) {
            System.out.println(player1.name + " turn");
            try {
                int firstPlayerTurn = Integer.parseInt(reader.readLine());
                definePlace(firstPlayerTurn, tic);
            } catch (Exception e) {

            }
            showTable();
            if (isGameOver())
                break;

            System.out.println(player2.name + " turn");
            try {
                int secondPlayerTurn = Integer.parseInt(reader.readLine());
                definePlace(secondPlayerTurn, tac);
            } catch (Exception e) {

            }

            showTable();
            if (isGameOver())
                break;
        }
        System.out.println("Game over!");

        if (isFirstPlayerWin) {
            System.out.println("Congradulations " + player1.name);
        } else if (isSecondPlayerWin) {
            System.out.println("Congradulations " + player2.name);
        } else if (tie) {
            System.out.println("Draw");
        }


    }

    public int[][] definePlace(int a, char figure) throws IOException {


        try {
            if (a == 1 && field[0][0] == '.')
                field[0][0] = figure;
            else if (a == 2 && field[0][1] == '.')
                field[0][1] = figure;
            else if (a == 3 && field[0][2] == '.')
                field[0][2] = figure;
            else if (a == 4 && field[1][0] == '.')
                field[1][0] = figure;
            else if (a == 5 && field[1][1] == '.')
                field[1][1] = figure;
            else if (a == 6 && field[1][2] == '.')
                field[1][2] = figure;
            else if (a == 7 && field[2][0] == '.')
                field[2][0] = figure;
            else if (a == 8 && field[2][1] == '.')
                field[2][1] = figure;
            else if (a == 9 && field[2][2] == '.')
                field[2][2] = figure;
        } catch (Exception e) {
            System.out.println("This cell is busy or you enter the wrong number\n"
                    + "Enter another one");

        }


        return field;

    }


    public void showTable() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print((char) field[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean isGameOver() {


        if (field[0][0] == field[1][0] && field[0][0] == field[2][0] && field[0][0] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[0][0] == field[0][1] && field[0][0] == field[0][2] && field[0][1] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[0][2] == field[1][2] && field[0][2] == field[2][2] && field[0][2] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[2][0] == field[2][1] && field[2][0] == field[2][2] && field[2][1] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[0][1] == field[1][1] && field[0][1] == field[2][1] && field[0][2] == tac) {
            isSecondPlayerWin = true;
            return true;
        } else if (field[1][0] == field[1][1] && field[1][0] == field[1][2] && field[1][0] == tac) {
            isSecondPlayerWin = true;
            return true;
        }
        if (field[0][0] == field[1][0] && field[0][0] == field[2][0] && field[0][0] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[0][0] == field[0][1] && field[0][0] == field[0][2] && field[0][1] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[0][2] == field[1][2] && field[0][2] == field[2][2] && field[0][2] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[2][0] == field[2][1] && field[2][0] == field[2][2] && field[2][1] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[0][1] == field[1][1] && field[0][1] == field[2][1] && field[0][2] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else if (field[1][0] == field[1][1] && field[1][0] == field[1][2] && field[1][0] == tic) {
            isFirstPlayerWin = true;
            return true;
        } else {
            tie = true;
            return false;
        }


    }

}
