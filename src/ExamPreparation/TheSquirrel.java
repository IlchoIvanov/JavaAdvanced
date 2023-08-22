package ExamPreparation;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hazelnuts = 0;
        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        String[] commandsArr = scanner.nextLine().split(", ");
        boolean isTrapped = false;
        boolean isFlyOut = false;
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
        }
        int squirrelFirstInedx = -1;
        int squirrelSecondInedx = -1;
        for (int i = 0; i < field.length; i++) {
            for (int i1 = 0; i1 < field[0].length; i1++) {
                if (field[i][i1].equals("s")) {
                    squirrelFirstInedx = i;
                    squirrelSecondInedx = i1;
                    break;
                }
            }
        }
        for (int i = 0; i < commandsArr.length; i++) {
            String command = commandsArr[i];
            if (command.equals("left")) {
                if (squirrelSecondInedx > 0) {
                    field[squirrelFirstInedx][squirrelSecondInedx] = "*";
                    squirrelSecondInedx--;
                } else {
                    isFlyOut = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }

            } else if (command.equals("right")) {
                if (squirrelSecondInedx < field[0].length - 1) {
                    field[squirrelFirstInedx][squirrelSecondInedx] = "*";
                    squirrelSecondInedx++;
                } else {
                    isFlyOut = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }

            } else if (command.equals("down")) {
                if (squirrelFirstInedx < field.length - 1) {
                    field[squirrelFirstInedx][squirrelSecondInedx] = "*";
                    squirrelFirstInedx++;
                } else {
                    isFlyOut = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }

            } else if (command.equals("up")) {
                if (squirrelFirstInedx > 0) {
                    field[squirrelFirstInedx][squirrelSecondInedx] = "*";
                    squirrelFirstInedx--;
                } else {
                    isFlyOut = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }

            }
            if (field[squirrelFirstInedx][squirrelSecondInedx].equals("h")) {
                hazelnuts++;
                field[squirrelFirstInedx][squirrelSecondInedx] = "s";
                if (hazelnuts >= 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    break;
                }

            } else if (field[squirrelFirstInedx][squirrelSecondInedx].equals("t")) {
                isTrapped = true;
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            } else {
                field[squirrelFirstInedx][squirrelSecondInedx] = "s";
            }
        }
        if (hazelnuts < 3 && isTrapped == false && isFlyOut == false) {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.println("Hazelnuts collected: " + hazelnuts);
    }
}
