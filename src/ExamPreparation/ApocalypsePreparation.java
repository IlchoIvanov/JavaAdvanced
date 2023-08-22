package ExamPreparation;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        Stack<Integer> meds = new Stack<>();
        int[] textArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] medsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> createdItems = new TreeMap<>();
        createdItems.put("Patch", 0);
        createdItems.put("Bandage", 0);
        createdItems.put("MedKit", 0);
        for (int med : medsArr) {
            meds.push(med);
        }
        for (int text : textArr) {
            textiles.offer(text);
        }

        while (!meds.isEmpty() && !textiles.isEmpty()) {
            int sum = meds.peek() + textiles.peek();
            if (sum == 30) {
                meds.pop();
                textiles.poll();
                createdItems.put("Patch", createdItems.get("Patch") + 1);
            } else if (sum == 40) {
                meds.pop();
                textiles.poll();
                createdItems.put("Bandage", createdItems.get("Bandage") + 1);
            } else if (sum == 100) {
                meds.pop();
                textiles.poll();
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
            } else if (sum > 100) {
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                int tempSum = sum - 100;
                meds.pop();
                textiles.poll();
                if(!meds.isEmpty()) {
                    meds.push(meds.pop() + tempSum);
                }
            } else {
                textiles.poll();
                meds.push(meds.pop() + 10);
            }
        }
        if (meds.isEmpty() && textiles.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (meds.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }
        createdItems.entrySet().stream().filter(e -> e.getValue() != 0).sorted(Collections.reverseOrder(comparingByValue())).forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
        if(!meds.isEmpty()){
            System.out.print("Medicaments left: ");
            System.out.println(String.join(", ", meds.toString()).replace("[", "").replace("]", "").trim());
        }
        if(!textiles.isEmpty()){
            System.out.print("Textiles left: ");
            System.out.println(String.join(", ", textiles.toString()).replace("[", "").replace("]", "").trim());
        }
    }
}
