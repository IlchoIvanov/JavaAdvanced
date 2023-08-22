package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean isbalansed = true;
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openingBrackets.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (openingBrackets.isEmpty()) {
                    isbalansed = false;
                    break;
                }
                char lastOpen = openingBrackets.pop();
                if (lastOpen == '(' && bracket == ')') {
                    isbalansed = true;
                } else if (lastOpen == '{' && bracket == '}') {
                    isbalansed = true;
                } else if (lastOpen == '[' && bracket == ']') {
                    isbalansed = true;
                } else {
                    System.out.println("NO");
                    return;
                }

            }
        }
        if (isbalansed) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
