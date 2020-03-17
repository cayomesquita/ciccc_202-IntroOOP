package collections.set;

import java.util.HashSet;
import java.util.stream.IntStream;

public class HashSetExample {


    public static void main(String[] args) {
        System.out.println(nextDistinctYear(999));
    }

    public static int nextDistinctYear(int yearBase) {

        for (int i = yearBase + 1; i < Integer.MAX_VALUE; i++) {
            if (isDistinct(i)) {
                return i;
            }

        }
        return -1;
    }

    private static boolean isDistinct(int i) {
        HashSet<Character> bag = new HashSet<>();
        char[] arr = String.valueOf(i).toCharArray();
        for (char c : arr) {
            bag.add(c);
        }
        return arr.length == bag.size();
    }
}
