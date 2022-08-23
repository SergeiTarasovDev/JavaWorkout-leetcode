package task_67_add_binary;

import java.math.BigInteger;

public class Solution {
    public String addBinary(String a, String b) {
        BigInteger bigA = BigInteger.valueOf(Integer.parseInt(a, 2));
        BigInteger bigB = BigInteger.valueOf(Integer.parseInt(b, 2));
        BigInteger bigSum = bigA.add(bigB);
        return Integer.toBinaryString(bigSum.intValue());
    }
}
