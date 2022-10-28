package de.thefoxymanuel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please use: java -jar sieve.jar <Max Number>");
            return;
        }

        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            System.out.println("Bitte gebe eine richtige Zahl an:");
            return;
        }

        boolean[] sieve = new boolean[Integer.parseInt(args[0])];
        Arrays.fill(sieve, true);

        for (int primeNumber = 2; primeNumber < Math.sqrt(sieve.length) + 2; primeNumber++) {
            if (sieve[primeNumber]) {
                for (int i = primeNumber; i < sieve.length; i++) {
                    int number = primeNumber * i;
                    if (number < sieve.length - 1) {
                        sieve[number] = false;
                    }
                }
            }
        }

        sieve[2] = false;

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        primes.forEach(System.out::println);
    }

}
