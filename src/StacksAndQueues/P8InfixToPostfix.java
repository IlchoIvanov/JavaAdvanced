package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P8InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int days = 0;
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        plants.push(scanner.nextInt());
        for (int i = 0; i < n - 1; i++) {
            int current = scanner.nextInt();

            if (!plants.isEmpty()) {
                if (current <= plants.peek()) {
                    plants.push(current);
                } else {
                    days++;
                }

            }
        }
        System.out.println(days - 2);

    }
}
