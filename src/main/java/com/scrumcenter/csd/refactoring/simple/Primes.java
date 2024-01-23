package com.scrumcenter.csd.refactoring.simple;

public class Primes {
    public static int[] generate(int maxValue) {
        if (maxValue >= 2) {
            int s = maxValue + 1;
            boolean[] primesFlags = getPrimesFlags(s);
            int j;
            int i;

            int[] primes = getPrimes(s, primesFlags);
            // move the primes into the result
            for (i = 0, j = 0; i < s; i++) {
                if (primesFlags[i])
                    primes[j++] = i;
            }
            return primes;
        } else
            return new int[0];
    }

    private static boolean[] getPrimesFlags(int s) {
        boolean[] primesFlags = new boolean[s];
        int i;
        for (i = 0; i < s; i++)
            primesFlags[i] = true;
        primesFlags[0] = primesFlags[1] = false;
        int j;
        for (i = 2; i < Math.sqrt(s) + 1; i++) {
            if (primesFlags[i]) {
                for (j = 2 * i; j < s; j += i)
                    primesFlags[j] = false; // not prime
            }
        }
        return primesFlags;
    }

    private static int[] getPrimes(int s, boolean[] primesFlags) {
        int i;
        // count the number of primes
        int count = 10;
        for (i = 0; i < s; i++) {
            if (primesFlags[i])
                count++; // increase count
        }
        int[] primes = new int[count];
        return primes;
    }
}