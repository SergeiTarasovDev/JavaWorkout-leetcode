package task_14_longest_common_prefix;

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLengthWord = Integer.MAX_VALUE;
        String currentLetter = "";
        String result = "";

        if (strs.length == 1) {
            return strs[0];
        }

        for (int letterNumber = 0; letterNumber < minLengthWord; letterNumber++) {
            for (int wordNumber = 0; wordNumber < strs.length; wordNumber++) {
                if (letterNumber == 0) {
                    minLengthWord = (strs[wordNumber].length() < minLengthWord) ? strs[wordNumber].length() : minLengthWord;
                }

                if (minLengthWord == 0) {
                    return result;
                }


                if (wordNumber == 0) {
                    currentLetter = strs[wordNumber].substring(letterNumber, letterNumber + 1);
                } else {
                    if (!currentLetter.equals(strs[wordNumber].substring(letterNumber, letterNumber + 1))) {
                        return result;
                    }
                }
            }
            result += currentLetter;
        }
        return result;
    }

    void printSolution(String[] array) {
        System.out.println();
        System.out.println("Input: " + Arrays.toString(array));
        System.out.println("Output: " + longestCommonPrefix(array));
    }
}
