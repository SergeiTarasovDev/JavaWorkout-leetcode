package task_09_Palindrome_number;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String number = Integer.toString(x);
        char[] arrayNumbers = number.toCharArray();
        for (int i = 0; i < arrayNumbers.length / 2 + 1; i++) {
            if (arrayNumbers[i] != arrayNumbers[arrayNumbers.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeWithFollowUp(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        List<Integer> numbersList = new ArrayList<>();
        while (x > 0) {
            numbersList.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < numbersList.size() / 2 + 1; i++) {
            if (!numbersList.get(i).equals(numbersList.get(numbersList.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeFasterSolution(int x) {
        int mod;
        int sum = 0;
        int originalNumber = x;

        while (x > 0) {
            mod = x % 10;
            sum = (sum * 10) + mod;
            x /= 10;
        }

        if (originalNumber == sum) {
            return true;
        }

        return false;
    }

    public void printSolution(int x) {
        System.out.println();
        System.out.println("Input = " + x);
        System.out.println("It's palindrome: " + isPalindromeFasterSolution(x));
    }
}
