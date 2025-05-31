package problem_solving.leetcode.easy;


import dsa.stacks.StackWithLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String parenthesis){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        StackWithLinkedList stack = new StackWithLinkedList(); // Essa stack não é genérica, teria que colocar como Caracter

        for(Character c : parenthesis.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
                continue;
            }

            if(stack.length == 0) return false;

            if(map.containsValue(c)){
                Integer top = stack.getTop();
                if(top == '(' && c == ')' ||
                   top == '[' && c == ']' ||
                   top == '{' && c == '}'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.length == 0;
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(((())))")); // true
        System.out.println(isValid("(((()))))")); // false
        System.out.println(isValid("((([[}]]))")); // false
        System.out.println(isValid("(){}[]")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("()")); // true
        System.out.println(isValid("(")); // false
//        System.out.println(isValidParenthesis("()[]{}")); // true
//        System.out.println(isValidParenthesis("(((())))")); // true
//        System.out.println(isValidParenthesis("(((()))))")); // false
//        System.out.println(isValidParenthesis("((([[}]]))")); // false
//        System.out.println(isValidParenthesis("(){}[]")); // true
//        System.out.println(isValidParenthesis("([)]")); // false
//        System.out.println(isValidParenthesis("()")); // true
//        System.out.println(isValidParenthesis("(")); // false

    }
}
