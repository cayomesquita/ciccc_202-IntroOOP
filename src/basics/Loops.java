package basics;

import sun.awt.SunToolkit;

public class Loops {
    public static void main(String[] args) {
        //        1. for-loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //        InfiniteLoop
        for (; ; ) {
            System.out.println("Hi");
            break;
        }

//        2. While-loop

//        Infinite
        while (true) {
            System.out.println("Bye");
            break;
        }

//        Exercise
//        Using for-loop
//        1. print integer from 1 to 20, but 10 numbers each line
        for (int index = 1; index <= 20; index++) {
            System.out.printf("%d%s", index, index % 10 == 0 ? "\n" : ", ");
        }

//        Using while-loop
//        2. print even numbers from 1 to 10
        int index = 1;
        while (index <= 10) {
            if (index % 2 == 0) {
                System.out.printf("%d ", index);
            }
            index++;
        }

    }
}
