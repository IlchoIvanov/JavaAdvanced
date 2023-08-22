package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if (numbers.length > 1) {
                stack.push(numbers[1]);
            } else {
                if (numbers[0] == 2) {
                    stack.pop();
                } else if (numbers[0] == 3) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
