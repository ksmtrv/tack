package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readSomething("x = ");
        double n = readSomething("the last degree n = ");
        double e = readSomething("e = ");

        if (!checkLimitations(x)) {
            System.out.println("X entered out of range (-1; 1)");
        } else {
            double resultSumFunction = calculateFunction(x);
            printValue("function using Math --> ", resultSumFunction);

            double resultSumSequence = calculateSumOfSequence(x, n);
            printValue("of the first N elements --> ", resultSumSequence);

            double resultSumOfSequenceEpsilon = calculateSumOfSequenceEpsilon(x, e, 0);
            int numberOfIterationsGreaterThanEpsilon = (int) calculateSumOfSequenceEpsilon(x, e, 1);
            printValueEpsilon(" ", resultSumOfSequenceEpsilon, numberOfIterationsGreaterThanEpsilon);

            double resultSumOfSequenceEpsilonDividedBy10 = calculateSumOfSequenceEpsilon(x, e / 10, 0);
            int numberOfIterationsGreaterThanEpsilonDividedBy10 = (int) calculateSumOfSequenceEpsilon(x, e / 10, 1);
            printValueEpsilon("/10 ", resultSumOfSequenceEpsilonDividedBy10, numberOfIterationsGreaterThanEpsilonDividedBy10);
        }
    }

    private static boolean checkLimitations(double x) {
        return x > -1 && x < 1;
    }

    private static double calculateSumOfSequence(double x, double n) {
        double sum = 1 + x / 2;
        double k = 2;

        for (int i = 2; i <= n; i++) {
            k = k * 2 * i;
            double result = getNMemberOfSequence(x, i, k);
            if (checkParity(i)) {
                sum = sum - result;
            } else {
                sum = sum + i * result;
            }
        }
        return sum;
    }

    private static double getNMemberOfSequence(double x, int motion, double k) {
        return Math.pow(x, motion) / k;
    }

    private static double calculateSumOfSequenceEpsilon(double x, double e, int i) {
        double sumEpsilon = 1;
        int iteration = 1;
        double k = 2;
        double result = x / 2;

        while (Math.abs(result) > e) {
            sumEpsilon += result;
            k = k * 2 * iteration;
            result = getNMemberOfSequence(x, iteration, k);
            iteration++;
        }
        double[] arraySum = {sumEpsilon, iteration};
        return arraySum[i];
    }

    private static boolean checkParity(int i) {
        return i % 2 != 1;
    }

    private static double calculateFunction(double x) {
        return Math.sqrt(1 + x);
    }

    private static double readSomething(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s ", name);
        return scanner.nextDouble();
    }

    private static void printValue(String phrase, double resultSum) {
        System.out.println("The sum" + phrase + resultSum);
    }

    private static void printValueEpsilon(String phrase, double resultSum, int resultIteration) {
        System.out.println("The sum of the first N elements superior in absolute value of the epsilon" +
                phrase + "number --> " + resultSum + ". For " + resultIteration + " number of elements");
    }
}