package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P1DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> males = new Stack<>();
        Queue<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            int firstFemale = females.peek();
            int lastMale = males.peek();
            if (firstFemale <= 0) {
                females.poll();
                continue;
            } else if (lastMale <= 0) {
                males.pop();
                continue;
            }
            if (firstFemale % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            } else if (lastMale % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (firstFemale == lastMale) {
                females.poll();
                males.pop();
                matches++;
            } else {
                females.poll();
                males.push(males.pop() - 2);

            }

        }
        System.out.println("Matches: " + matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String result = males.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Males left: " + result);
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String result = females.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + result);
        }
    }
}
