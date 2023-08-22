package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(int num : numbers){
            nums.push(num);
        }
        while (!nums.isEmpty()){
            System.out.print(nums.pop() + " ");
        }
    }
}
