package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            stack.push(String.valueOf(tokens[i]));
        }
        for (int i = 0; i < numbers[1]; i++) {
            stack.pop();
        }
        if(stack.contains(String.valueOf(numbers[2]))){
            System.out.println(true);
        }else if(stack.isEmpty()){
            System.out.println("0");
        }else{
            System.out.println(Collections.min(stack));
        }
    }
}
