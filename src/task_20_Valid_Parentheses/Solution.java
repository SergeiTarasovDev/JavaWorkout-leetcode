package task_20_Valid_Parentheses;

import java.util.*;

class Solution {

    public void printSolution(String s) {
        if (isValid(s)) {
            System.out.println("line: '" + s + "' - valid");
        } else {
            System.out.println("line: '" + s + "' - invalid");
        }
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        char prevSymbol;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char symbol: charArray) {
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
                continue;
            }

            if ( stack.empty() && (symbol == ')' || symbol == '}' || symbol == ']') ) {
                return false;
            }

            prevSymbol = stack.peek();

            if (symbol == map.get(prevSymbol)) {
                stack.pop();
                continue;
            }

            if ( (prevSymbol == '(' && symbol != ')') || (prevSymbol == '{' && symbol != '}') || (prevSymbol == '[' && symbol != ']') ) {
                return false;
            }
        }

        return stack.empty();
    }

}
