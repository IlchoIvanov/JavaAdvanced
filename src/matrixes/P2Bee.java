package matrixes;

import java.util.Scanner;

public class P2Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        for (int row = 0; row < n; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
        int firstBeeIndex = -1;
        int secondBeeIndex = -1;
        int polinatedFlowers = 0;
        for (int i = 0; i < field.length; i++) {
            for (int i1 = 0; i1 < field[0].length; i1++) {
                if (field[i][i1] == 'B') {
                    firstBeeIndex = i;
                    secondBeeIndex = i1;
                    break;
                }
            }
        }
        boolean flyOut = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.equals("left")) {
                if (secondBeeIndex > 0) {
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    secondBeeIndex -= 1;

                    if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                        polinatedFlowers++;
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    } else if (field[firstBeeIndex][secondBeeIndex] == 'O') {
                        field[firstBeeIndex][secondBeeIndex] = '.';
                        secondBeeIndex -= 1;
                        if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                            polinatedFlowers++;
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        } else {
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        }
                    } else {
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    }

                } else {
                    flyOut = true;
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    break;

                }
            } else if (command.equals("right")) {
                if (secondBeeIndex < field[0].length - 1) {
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    secondBeeIndex += 1;

                    if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                        polinatedFlowers++;
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    } else if (field[firstBeeIndex][secondBeeIndex] == 'O') {
                        field[firstBeeIndex][secondBeeIndex] = '.';
                        secondBeeIndex += 1;
                        if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                            polinatedFlowers++;
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        } else {
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        }
                    } else {
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    }

                } else {
                    flyOut = true;
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    break;

                }

            } else if (command.equals("down")) {
                if (firstBeeIndex < field.length - 1) {
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    firstBeeIndex += 1;

                    if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                        polinatedFlowers++;
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    } else if (field[firstBeeIndex][secondBeeIndex] == 'O') {
                        field[firstBeeIndex][secondBeeIndex] = '.';
                        firstBeeIndex += 1;
                        if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                            polinatedFlowers++;
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        } else {
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        }
                    } else {
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    }

                } else {
                    flyOut = true;
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    break;

                }
            } else if (command.equals("up")) {
                if (firstBeeIndex > 0) {
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    firstBeeIndex -= 1;

                    if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                        polinatedFlowers++;
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    } else if (field[firstBeeIndex][secondBeeIndex] == 'O') {
                        field[firstBeeIndex][secondBeeIndex] = '.';
                        firstBeeIndex -= 1;
                        if (field[firstBeeIndex][secondBeeIndex] == 'f') {
                            polinatedFlowers++;
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        } else {
                            field[firstBeeIndex][secondBeeIndex] = 'B';
                        }
                    } else {
                        field[firstBeeIndex][secondBeeIndex] = 'B';
                    }

                } else {
                    flyOut = true;
                    field[firstBeeIndex][secondBeeIndex] = '.';
                    break;

                }
            }
            command = scanner.nextLine();
        }
        if (flyOut) {
            System.out.println("The bee got lost!");
        }
        if (polinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - polinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", polinatedFlowers);
        }
        for (int i = 0; i < field.length; i++) {
            for (int i1 = 0; i1 < field[0].length; i1++) {
                System.out.print(field[i][i1]);
            }
            System.out.println();
        }

    }
}

