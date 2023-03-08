//Weston Forbes 2023

import java.util.Scanner;

public class InterestCalculator {

    public static float principle; //The initial sum of money.
    public static float rate; //In a regular percentage (non decimal).
    public static float timespan; // Timespan in years.
    public static float interest; //The amount of interest earned.
    public static boolean hasP, hasR, hasT, hasI;

    public static boolean prompting = true;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listIndex = 0;

        while (prompting) {
            switch (listIndex) {
                case 0:
                    System.out.println("What's the principle (P), if not known; enter 0");

                    if (scanner.hasNextFloat()) {
                        float next = scanner.nextFloat();

                        if (next == 0) {
                            System.out.println("Principle unknown");
                            listIndex = 1;
                        }
                        else if(next > 0) {
                            principle = next;
                            hasP = true;
                            listIndex = 1;
                        }
                    }


                    break;
                case 1:
                    System.out.println("What's the interest rate (I), if not known; enter 0");
                    if (scanner.hasNextFloat()) {
                        float next = scanner.nextFloat();

                        if (next == 0) {
                            System.out.println("Rate unknown");
                            listIndex = 2;
                        }
                        else if(next > 0) {
                            rate = next;
                            hasR = true;
                            listIndex = 2;
                        }
                    }
                    break;
                case 2:
                    System.out.println("What's the timespan in years (T), or a fraction, if not known; enter 0");
                    if (scanner.hasNextFloat()) {
                        float next = scanner.nextFloat();

                        if (next == 0) {
                            System.out.println("Timespan unknown");
                            listIndex = 3;
                        }
                        else if(next > 0) {
                            timespan = next;
                            hasT = true;
                            listIndex = 3;
                        }
                    }
                    break;
                case 3:
                    System.out.println("What is the final interest amount (I), if not known; enter 0");
                    if (scanner.hasNextFloat()) {
                        float next = scanner.nextFloat();

                        if (next == 0) {
                            System.out.println("Interest unknown");
                            prompting = false;
                        }
                        else if(next > 0) {
                            interest = next;
                            hasI = true;
                            prompting = false;
                        }
                    }
                    break;
            }
        }


        if (hasP && hasR && hasT) {
            System.out.println("Solving for Interest");

            System.out.println("Interest is - " + SolveForInterest(principle, rate, timespan));
            System.out.println("Total amount to be paid is - " + (principle + SolveForInterest(principle, rate, timespan)));
        } else if (hasR && hasT && hasI) {
            System.out.println("Solving for Principle");

            System.out.println("Principle is - " + SolveForPrinciple(rate, timespan, interest));
        } else if (hasR && hasI && hasP) {
            System.out.println("Solving for Time");

            System.out.println("Timespan is - " + SolveForTime(rate, interest, principle) + " in years.");
        } else if (hasI && hasP && hasT) {
            System.out.println("Solving for Rate");

            System.out.println("Rate is - " + SolveForRate(interest, principle, timespan));
        }

        scanner.close();
    }


    //Formulas fetched from https://www.calculatorsoup.com/calculators/financial/simple-interest-calculator.php

    /**
     * @param p
     * @param r
     * @param t
     * @return
     */
    public static float SolveForInterest(float p, float r, float t) {
        float i = (p * r * t);
        return i;
    }

    /**
     * @param r
     * @param t
     * @param i
     * @return
     */
    public static float SolveForPrinciple(float r, float t, float i) {
        float p = i / r * t;
        return p;
    }

    /**
     * @param r
     * @param i
     * @param p
     * @return
     */
    public static float SolveForTime(float r, float i, float p) {
        float t = i / p * r;
        return t;
    }

    /**
     * @param i
     * @param p
     * @param t
     * @return
     */
    public static float SolveForRate(float i, float p, float t) {
        float r = i / p * t;
        return r;
    }
}
