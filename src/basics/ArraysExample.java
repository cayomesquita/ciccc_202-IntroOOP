package basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysExample {
    public static void main(String[] args) {
//        Array 'Fixed size'
//        1. array-literal
        int[] arr1 = {1, 2, 3, 4, 5};

        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1[arr1.length - 1]);

        for (int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }

        arr1[0] = 7;

        for (int i : arr1) {
            System.out.println(i);
        }

//        2. create an array with the "size"
        int[] arr2 = new int[10];

        System.out.println(arr2);


    }
}
