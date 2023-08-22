package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        Collections.addAll(stack, tokens);
        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            int second = Integer.valueOf(stack.pop());
            if (operator.equals("+")) {
                stack.push(String.valueOf(first + second));
            } else if (operator.equals("-")) {
                stack.push(String.valueOf(first-second));
            }
        }
        System.out.println(stack.pop());
    }
}
