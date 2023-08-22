package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> programmerTime = new ArrayDeque<>();
        Stack<Integer> tasksPerProgrammer = new Stack<>();
        int[] firsttokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondtokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int dartVaderDuckCount = 0;
        int thorDuckCount = 0;
        int blueDuckCount = 0;
        int smallDuckCount = 0;
        for (int firs : firsttokens) {
            programmerTime.offer(firs);
        }
        for (int second : secondtokens) {
            tasksPerProgrammer.push(second);
        }
        while (!programmerTime.isEmpty() && !tasksPerProgrammer.isEmpty()) {
            int value = programmerTime.peek() * tasksPerProgrammer.peek();
            if (value > 240) {
                int temp = programmerTime.poll();
                programmerTime.offer(temp);
                tasksPerProgrammer.push(tasksPerProgrammer.pop() - 2);
            } else if (value >= 181) {
                programmerTime.poll();
                tasksPerProgrammer.pop();  
                smallDuckCount++;
            } else if (value >= 121) {
                programmerTime.poll();
                tasksPerProgrammer.pop();
                blueDuckCount++;
            } else if (value >= 61) {
                programmerTime.poll();
                tasksPerProgrammer.pop();
                thorDuckCount++;
            } else if (value >= 0) {
                dartVaderDuckCount++;
                programmerTime.poll();
                tasksPerProgrammer.pop();

            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + dartVaderDuckCount);
        System.out.println("Thor Ducky: " + thorDuckCount);
        System.out.println("Big Blue Rubber Ducky: " + blueDuckCount);
        System.out.println("Small Yellow Rubber Ducky: " + smallDuckCount);
    }
}

