package task_13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * solution.printSolution("MDCXCV"); // 1695 = 1000 + 500 + 100 + 90
 */
public class Solution {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;

        if (array.length == 1) {
            return map.get(array[0]);
        }

        for (int i = 1; i < array.length; i++) {
            int prevNumber = map.get(array[i - 1]);
            int currentNumber = map.get(array[i]);
            if (prevNumber < currentNumber) {
                if (prevNumber == 1 && currentNumber == 5) {
                    sum += 4;
                    i++;
                } else if (prevNumber == 1 && currentNumber == 10) {
                    sum += 9;
                    i++;
                } else if (prevNumber == 10 && currentNumber == 50) {
                    sum += 40;
                    i++;
                } else if (prevNumber == 10 && currentNumber == 100) {
                    sum += 90;
                    i++;
                } else if (prevNumber == 100 && currentNumber == 500) {
                    sum += 400;
                    i++;
                } else if (prevNumber == 100 && currentNumber == 1000) {
                    sum += 900;
                    i++;
                }
                if (i == array.length - 1) {
                    sum += map.get(array[i]);;
                }
            } else {
                sum += prevNumber;
                if (i == array.length - 1) {
                    sum += currentNumber;
                }
            }
        }
        return sum;
    }

    public int romanToIntOptimal(String s) {
        int n = 0;
        char prev = ' ';
        for (byte i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n += getValue(c, prev);
            prev = c;
        }

        return n;
    }

    private int getValue(char c, char prev) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return prev == 'I' ? 3 : 5;
            case 'X':
                return prev == 'I' ? 8 : 10;
            case 'L':
                return prev == 'X' ? 30 : 50;
            case 'C':
                return prev == 'X' ? 80 : 100;
            case 'D':
                return prev == 'C' ? 300 : 500;
            case 'M':
                return prev == 'C' ? 800 : 1000;
        }

        throw new IllegalArgumentException();
    }

    public void printSolution(String s) {
        System.out.println();
        System.out.println("Входящая строка: " + s);
        System.out.println("Результат конвертации: " + romanToInt(s));
    }
}
