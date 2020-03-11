package collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Coke");
        queue.offer("Pepsi");
        queue.offer("Ginger Ale");
        queue.offer("Sprite");
        queue.offer("Fanta");

        Queue<Integer> qInt = new LinkedList<>();
        qInt.offer(1);
        qInt.offer(2);
        qInt.offer(3);
        stutter(qInt);
        while (!qInt.isEmpty()) {
            System.out.println(qInt.poll());
        }
        Queue<String> qStr = new LinkedList<>();
        qStr.offer("a");
        qStr.offer("b");
        qStr.offer("c");
        mirror(qStr);
        while (!qStr.isEmpty()) {
            System.out.println(qStr.poll());
        }
    }

    private static void stutter(Queue<Integer> queue){
        int length = queue.size();

        while (length--> 0){
            Integer e = queue.poll();
            queue.offer(e);
            queue.offer(e);
        }
    }

    private static void mirror(Queue<String> queue){
        Deque<String> aux = new ArrayDeque<>();
        int length = queue.size();
        while (length--> 0){
            String e = queue.poll();
            aux.push(e);
            queue.offer(e);
        }
        while (!aux.isEmpty()) {
            queue.offer(aux.pop());
        }
    }


}
