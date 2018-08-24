package com.company;

public class Main {

    public static void main(String[] args) {
        Thread[] threads = {new FizzBuzzThread(true, false, "Fizz"),
                            new FizzBuzzThread(false, true, "Buzz"),
                            new FizzBuzzThread(true, true, "FizzBuzz"),
                            new FizzBuzzThread(false, false, null)};
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
