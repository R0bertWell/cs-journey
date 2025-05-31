package problem_solving.challenges;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class BalancedString {


    public static boolean isBalanced(String str){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> deque = new ArrayDeque<>();

        char c = str.charAt(0);
        deque.add(c);
        int firstIndex = 1;
        int lastIndex = 1;
        for(int i = 1; i < str.length(); i++){
            c = str.charAt(i);
            if(!deque.isEmpty() && map.get(deque.getFirst()).equals(c)){
                if(lastIndex != i) {
                    deque.add(c);
                }
                if(deque.size() > 1){
                    i = str.indexOf(deque.getFirst()) + 1;
                }
                deque.removeFirst();
                deque.removeLast();
                if(deque.isEmpty()){
                    i = lastIndex + 1;
                }
            } else {
                lastIndex = i;
                deque.add(c);
            }
        }

        return deque.isEmpty();
    }

    public static boolean isBalanced2(String str){
        if(str == null || str.isEmpty()) return true;
        if(str.length() == 1)return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('}', '_');
        map.put(']', '_');
        map.put(')', '_');


        Deque<Character> deque = new ArrayDeque<>();

//        char c = str.charAt(0);
//        deque.add(c);
        int compIndex = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.get(str.charAt(compIndex)).equals(c)){
                deque.removeLast();
                if(!deque.isEmpty()) {
                    compIndex--;
                }
            } else {
                compIndex = i;
                deque.add(c);
            }
        }

        return deque.isEmpty();
    }

    public static boolean isBalancedCorrect(String s) {
        // Se a string for nula ou vazia, pode ser considerada balanceada.
        if (s == null || s.isEmpty()) {
            return true;
        }

        // Pilha para armazenar os caracteres de abertura.
        Deque<Character> stack = new ArrayDeque<>();

        // Itera por cada caractere da string.
        for (char c : s.toCharArray()) {
            // Se for um caractere de abertura, empilha.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Se for um caractere de fechamento, verifica se há correspondência.
            else if (c == ')' || c == '}' || c == ']') {
                // Se a pilha estiver vazia, não há caractere correspondente.
                if (stack.isEmpty()) {
                    return false;
                }

                // Remove o elemento do topo da pilha para comparar.
                char top = stack.pop();

                // Verifica se o par forma um conjunto correto.
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        // Se ao final a pilha estiver vazia, todos os pares foram fechados corretamente.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.printf("Is balanced, true : %b", isBalanced2("([])(){}(())()()"));
        System.out.println();
        System.out.printf("Is balanced, false : %b", isBalanced2("([)(){}(())()()"));
        System.out.println();
        System.out.printf("Is balanced true: %b", isBalanced2("(())"));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2(")("));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2("("));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2(")"));
        System.out.println();
        System.out.printf("Is balanced true: %b", isBalanced2("([{}])"));
        System.out.println();
        System.out.printf("Is balanced true: %b", isBalanced2("([{{{{}}}}])"));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2("({[)]}"));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2("(([])"));
        System.out.println();
        System.out.printf("Is balanced false: %b", isBalanced2("({)}"));

    }
}
