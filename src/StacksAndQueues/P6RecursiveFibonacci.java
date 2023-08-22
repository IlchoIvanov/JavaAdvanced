package StacksAndQueues;

import java.util.Scanner;

public class P6RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

    }
    private static long fib(int n){
        if(n<=2){
            return  1;
        }
        return fib(n-1) + fib(n-2);
    }
    private static long fact(long n){
        if(n<1){
            return 1;
        }
        return fact(n-1)*n;
    }
}
