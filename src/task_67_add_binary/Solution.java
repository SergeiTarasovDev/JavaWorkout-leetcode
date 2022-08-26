package task_67_add_binary;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {

    // error: NumberFormatException for input string:
    //      "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101" и
    //      "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
    public String addBinaryErrorVersion(String a, String b) {
        BigInteger bigA = BigInteger.valueOf(Integer.parseInt(a, 2));
        BigInteger bigB = BigInteger.valueOf(Integer.parseInt(b, 2));
        BigInteger bigSum = bigA.add(bigB);
        return Integer.toBinaryString(bigSum.intValue());
    }

    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        } else if ((a.equals("1") && b.equals("0")) || (a.equals("0") && b.equals("1"))) {
            return "1";
        }

        while (a.length() > b.length()) {
            b = "0" + b;
        }

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        String resultString = "";
        String elemArrayA = "";
        String elemArrayB = "";
        String elemInMind = "0";

        for (int i = arrayA.length - 1; i >= 0; i--) {
            elemArrayA = String.valueOf(arrayA[i]);
            elemArrayB = String.valueOf(arrayB[i]);

            if (elemInMind.equals("1")) {
                if (elemArrayB.equals("0") && elemArrayA.equals("0")) {
                    resultString = "1" + resultString;
                    elemInMind = "0";
                } else if ((elemArrayB.equals("0") && elemArrayA.equals("1")) || (elemArrayA.equals("0") && elemArrayB.equals("1"))) {
                    resultString = "0" + resultString;
                    elemInMind = "1";
                } else if (elemArrayB.equals("1") && elemArrayA.equals("1")) {
                    resultString = "1" + resultString;
                    elemInMind = "1";
                }
            } else if (elemInMind.equals("0")) {
                if (elemArrayB.equals("0")) {
                    resultString = elemArrayA + resultString;
                } else if (elemArrayA.equals("0")) {
                    resultString = elemArrayB + resultString;
                } else if (elemArrayB.equals("1") && elemArrayA.equals("1")) {
                    resultString = "0" + resultString;
                    elemInMind = "1";
                }
            }
        }
        if (elemInMind.equals("1")) {
            resultString = elemInMind + resultString;
        }

        return resultString;
    }

    public String addBinaryOptimal(String a, String b) {
        StringBuilder result = new StringBuilder();
        int iteratorA = a.length() - 1;
        int iteratorB = b.length() - 1;
        int remainder = 0;
        while (iteratorA >= 0 || iteratorB >= 0) {
            int sum = remainder;
            if (iteratorB >= 0) {
                sum = sum + b.charAt(iteratorB) - '0';
                iteratorB--;
            }
            if (iteratorA >= 0) {
                sum = sum + a.charAt(iteratorA) - '0';
                iteratorA--;
            }
            result.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) result.append(remainder);
        return result.reverse().toString();
    }

    public void printSolution(String a, String b) {
        System.out.println();
        System.out.printf("Given two binary strings: %s и %s \r\n", a, b);
        System.out.println("Their sum as a binary string: " + addBinaryOptimal(a, b));
    }
}
