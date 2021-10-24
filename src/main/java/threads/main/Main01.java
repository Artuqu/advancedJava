package threads.main;

import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 2, 3, 4};
        solution(arr);
        System.out.println(Arrays.toString((arr)));
    }


    public static int solution(int[] A) {
        Arrays.sort(A);
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i + 1] < A.length) {
                if (A[i] > A[i + 1]) {
                    System.out.println("Value is smaller than zero!");
                    return 0;
                }
            }
        }
        return result;
    }

}

//class Solution {
//    public int solution(int[] A) {
//        Arrays.sort(A);
//        // write your code in Java SE 8
//        for(int i=0;i<A.lenght;i++){
//
//        }
//
//    }
//}

