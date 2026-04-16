import java.util.*;

class Solution {
    public static boolean isKDistinct(char[] arr, int start, int end, int k) {
        Set<Character> set = new HashSet<>();

        for (int i = start; i <= end; i++) {
            set.add(arr[i]);
        }

        return set.size() == k;
    }
    public static int countKDistinct(String s, int k) {
        int count = 0;

        // convert string to char array
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (isKDistinct(arr, i, j, k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;

        int result = countKDistinct(s, k);
        System.out.println(result);
    }
}