package com.company;

/**
 * This class contain implementation of thread which allow different version of this thread
 *   print data into console log based on it's own logic which set by constructor:
 *   div3Flag | div5Flag | strToPrint | printed on console
 *   false    | false    | null *     | current number (1,2,4...)
 *   true     | false    | "Fizz"     | "Fizz"
 *   false    | true     | "Buzz"     | "Buzz"
 *   true     | true     | "FizzBuzz" | "FizzBuzz"
 *
 *   * null must be used to be able to print numbers (see Print implementation)
 */
public class FizzBuzzThread extends Thread {
    // mutex
    private static final Object lock = new Object();

    // flag that this thread should verify that current number should be divided to 3 with or without reminder
    private boolean div3Flag;
    // flag that this thread should verify that current number should be divided to 3 with or without reminder
    private boolean div5Flag;
    // string to print when cNumber divided without reminder on number related to div3Flag and div5Flag
    // null should be set by the thread which should print numbers instead of words
    private String strToPrint;

    // current number.
    // it should be static since all threads should be able to increment it during its logic.
    // it will incremented from 1 to 100 at any thread
    private static int cNumber = 1;

    /**
     * Default public constructor
     * @param div3Flag flag that current thread should print Fuzz instead of all numbers div by 3
     * @param div5Flag flag that current thread should print Buzz instead of all numbers div by 5
     * @param strToPrint string to be printed instead of number ("Buzz", "Fuzz" or "FizzBuzz")
     */
    FizzBuzzThread(boolean div3Flag, boolean div5Flag, String strToPrint) {
        this.div3Flag = div3Flag;
        this.div5Flag = div5Flag;
        this.strToPrint = strToPrint;
    }

    /**
     * Print strToPrint
     */
    private void Print(){
        System.out.println(strToPrint== null?cNumber:strToPrint);
    }

    /**
     * Main thread loop which iterate thru the numbers from 1 to 100 and print string for related number
     */
    public void run() {
        while (true)
        {
            // lock mutex to synchronize threads access to cNumber
            synchronized (lock) {
                if (cNumber > 100)
                    return; // exit thread when all numbers are printed

                if (((cNumber % 3 == 0) == div3Flag) &&
                        ((cNumber % 5 == 0) == div5Flag)) {
                    // each thread will entered into this cycle when cNumber will:
                    // 1. deleted without reminder only on 3 (by thread created with (true, false, ...)
                    // 2. deleted without reminder only on 5 (by thread created with (false, true, ...)
                    // 3. deleted without reminder only on 15 (by thread created with (true, true, ...)
                    // 4. all other cases when cNumber div by 3,5 or 15 with reminder (related thread OtherNumTread)
                    Print();
                    cNumber++;
                }
            }
        }
    }
}
