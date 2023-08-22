package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] toolsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] substancesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Stack<Integer> substances = new Stack<>();
        ArrayDeque<Integer> tools = new ArrayDeque<>();
        for (int tool : toolsArr) {
            tools.offer(tool);
        }
        for (int substance : substancesArr) {
            substances.push(substance);
        }
        while (!substances.isEmpty() && !tools.isEmpty() && !challenges.isEmpty()) {
            int curr = substances.peek() * tools.peek();
            boolean flag = false;
            for (int challenge : challenges) {
                if (curr == challenge) {
                    challenges.remove(Integer.valueOf(challenge));
                    tools.poll();
                    substances.pop();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                tools.offer(tools.poll() + 1);
                substances.push(substances.pop() - 1);
                if (substances.peek() <= 0) {
                    substances.pop();
                }
            }
        }
        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (!tools.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(String.join(", ", tools.toString().replace("[", "").replace("]", "")));
        }
        if (!substances.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(String.join(", ", substances.toString().replace("[", "").replace("]", "")));
        }
        if (!challenges.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(String.join(", ", challenges.toString().replace("[", "").replace("]", "")));
        }
    }
}
