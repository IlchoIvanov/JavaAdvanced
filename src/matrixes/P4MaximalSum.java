package matrixes;

import java.util.Arrays;
import java.util.Scanner;

public class P4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] demensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = demensions[0];
        int cols = demensions[1];
        int[][] matrix = new int[rows][cols];
        int[][] result = new int[3][3];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = 0;
        for (int row = 0; row <= matrix.length-3; row++) {
            for (int col = 0; col <= matrix[0].length-3; col++) {
                int currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2]
                        + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2]
                        + matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                if(currentSum>maxSum){
                    maxSum = currentSum;
                    result = new  int[][]{
                            {matrix[row][col] , matrix[row][col+1] , matrix[row][col+2]},
                            { matrix[row+1][col] , matrix[row+1][col+1] , matrix[row+1][col+2]},
                            { matrix[row+2][col] , matrix[row+2][col+1] , matrix[row+2][col+2]}
                    };

                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[0].length; i1++) {
                System.out.print(result[i][i1] + " ");
            }
            System.out.println();
        }
    }
}
