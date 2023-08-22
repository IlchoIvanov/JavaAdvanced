package ExamPreparation;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> food = new Stack<>();
        Queue<Integer> stamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(food::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stamina::offer);
        List<String> conqueredPeaks = new ArrayList<>();
        int[] peaksArr = {80, 90, 100, 60, 70};
        String[] peaksNames = {"Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"};
        int days = 0;
        int i = 0;

        while (!food.isEmpty() && !stamina.isEmpty()) {
            if (days == 7) {
                break;
            }
            days++;
            int result = food.pop() + stamina.poll();
            if (result >= peaksArr[i]) {
                conqueredPeaks.add(peaksNames[i]);
                i++;
                if (conqueredPeaks.size() == 5) {
                    break;
                }
            }
        }
        if (conqueredPeaks.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        }
    }
}
