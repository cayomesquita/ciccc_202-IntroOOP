package collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackExample {

    private static final char PARENTHESES_OPEN = '(';
    private static final char PARENTHESES_CLOSE = ')';
    private static final char CURLY_BRACKTES_OPEN = '{';
    private static final char CURLY_BRACKTES_CLOSE = '}';

    public static void main(String[] args) {
        System.out.println(checkBalance("(){}"));
        System.out.println(checkBalance("dwq  1 = 3 d( ad (Asd )a as{ asda } dads)asd{}"));
        System.out.println(checkBalance("((()())())))){}"));
        System.out.println(checkBalance("{{{{(((("));
        System.out.println(checkBalance("(){}(){}{{(({}))}}"));
    }

    /**
     * @param code
     * @return -1 if code's () or {} are balanced
     * the index at which an imbalance occurs
     * the length of code if ( or { are never closed
     */
    public static int checkBalance(String code) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < code.length(); i++) {
            char character = code.charAt(i);
            if (character == PARENTHESES_OPEN || character == CURLY_BRACKTES_OPEN) {
                stack.push(character);
            } else if (character == PARENTHESES_CLOSE || character == CURLY_BRACKTES_CLOSE) {
                if (stack.isEmpty()) {
                    return i;
                }
                char aux = stack.peek().charValue();
                if ((character == PARENTHESES_CLOSE && aux == PARENTHESES_OPEN) ||
                        (character == CURLY_BRACKTES_CLOSE && aux == CURLY_BRACKTES_OPEN)) {
                    stack.pop();
                } else {
                    return i;
                }

            }
        }
        return stack.isEmpty() ? -1 : code.length();
    }
}
