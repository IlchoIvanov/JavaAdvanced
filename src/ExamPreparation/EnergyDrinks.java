package ExamPreparation;

import java.util.*;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> caffeine = new Stack<>();
        Queue<Integer> drinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(caffeine::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(drinks::offer);
        int amount = 0;
        while (!caffeine.isEmpty() && !drinks.isEmpty()) {
            int result = caffeine.peek() * drinks.peek();
            caffeine.pop();
            if (result + amount > 300) {
                drinks.offer(drinks.poll());
                if (amount >= 30) {
                    amount -= 30;
                } else {
                    amount = 0;
                }
            } else {
                drinks.poll();
                amount += result;
            }
        }
        if (!drinks.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(String.join(", ", drinks.toString()).replace("[", "").replace("]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", amount);
    }
}
