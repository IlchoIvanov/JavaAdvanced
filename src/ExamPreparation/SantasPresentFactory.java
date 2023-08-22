package ExamPreparation;

import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> toys = new ArrayDeque<>();
        ArrayDeque<Integer> magic = new ArrayDeque<>();
        int[] inputToys = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputmagic = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < inputToys.length; i++) {
            toys.push(inputToys[i]);
        }
        for (int i = 0; i < inputmagic.length; i++) {
            magic.offer(inputmagic[i]);
        }
        int totalMagicLevel = 0;
        if(toys.peek()*magic.peek()==150){

        }else if(toys.peek()*magic.peek()==250){

        }else if(toys.peek()*magic.peek()==300) {

        }
            else if(toys.peek()*magic.peek()==400){

        }else if(toys.peek()*magic.peek()<0){
                int sum = toys.pop() + magic.poll();
                toys.push(sum);
        }else if(toys.peek()*magic.peek()==0){
            if(toys.peek()==0){
                toys.pop();
            }
            if(magic.peek()==0){
                magic.poll();
            }
        }else{
                magic.poll();
                int newToy = toys.pop() + 15;
                toys.push(newToy);
        }

    }
}
