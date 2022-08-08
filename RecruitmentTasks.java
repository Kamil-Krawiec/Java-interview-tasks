package Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RecruitmentTasks {

//    ------------------------------------------------------------------------------

    public void fibbo(int n) {
        helperFibbo(n, 1, 1);
    }

    private int helperFibbo(int index, int prev, int curr) {
        if (index == 0) {
            return 0;
        } else {
            System.out.println(prev);
            return helperFibbo(index - 1, curr, prev + curr);
        }
    }

//    ------------------------------------------------------------------------------

    public boolean is_prime(int number) {

        if (number == 2) return true;
        if (number % 2 == 0 || number == 1) return false;

        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0 && number != i) return false;
        }

        return true;
    }

//    ------------------------------------------------------------------------------

    public boolean is_palindrome(String word) {
        int iterator = word.length() - 1;
        for (int i = 0; i < iterator; i++) {

            if (word.charAt(i) != word.charAt(iterator)) return false;

            iterator--;
        }
        return true;
    }

//    ------------------------------------------------------------------------------

    public boolean is_armstrong_number(int number) {
        return helper_is_armstrong_number(number) == number;
    }

    private double helper_is_armstrong_number(int number) {
        if (Integer.toString(number).length() == 1) return Math.pow(number, 3);
        else {
            double digit = number % 10;
            return Math.pow(digit, 3) + helper_is_armstrong_number(number / 10);
        }
    }

//    ------------------------------------------------------------------------------

    public double factorial(double n) {
        double fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }

//    ------------------------------------------------------------------------------

    public String reverse_string(String word) {
        String reversed_str = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed_str += word.charAt(i);
        }
        return reversed_str;
    }

//    ------------------------------------------------------------------------------

    public static <T> T[] removeDuplicate2(T[] src) {
        HashSet<T> temp = new HashSet<>();

        for (int i = 0; i < src.length; i++) {
            temp.add(src[i]);
        }
        return (T[]) temp.toArray();
    }

//    ------------------------------------------------------------------------------

    public double square_root(double number) {

        return square_root_helper(number, 50, number / 2);
    }

    private double square_root_helper(double number, int iterations, double x0) {
        if (iterations == 0) return x0;
        else {
            double sqr = ((x0 * x0) + number) / (2 * x0);
            return square_root_helper(number, iterations - 1, sqr);
        }
    }

//    ------------------------------------------------------------------------------

    public int binary_search(int[] arr, int element) {
        int len = arr.length;
        return binary_search_helper(arr, 0, len - 1, element);
    }

    private int binary_search_helper(int[] arr, int beg, int end, int element) {
        int mid = (beg + end) / 2;

        if (beg > end) return -1;
        else if (element == arr[mid]) return mid;
        else if (arr[mid] < element) {
            return binary_search_helper(arr, mid + 1, end, element);
        } else if (arr[mid] > element) {
            return binary_search_helper(arr, mid - 1, end, element);
        }

        return -1;
    }

//    ------------------------------------------------------------------------------

    public int[] quicksort(int[] arr) {
        quicksort_helper(arr, 0, arr.length - 1);
        return arr;
    }

    private void quicksort_helper(int[] arr, int beg, int end) {
        if (end > beg) {
            int participate = quicksort_participate(arr, beg, end);

            quicksort_helper(arr, beg, participate - 1);
            quicksort_helper(arr, participate + 1, end);
        }

    }

    private int quicksort_participate(int[] arr, int beg, int end) {
        int pivot = arr[end];
        int border = beg - 1;

        for (int j = beg; j < end; j++) {
            if (pivot >= arr[j]) {
                border++;

                int tempSwap = arr[j];
                arr[j] = arr[border];
                arr[border] = tempSwap;

            }
        }
        int index = border + 1;
        arr[end] = arr[index];
        arr[index] = pivot;

        return index;
    }

//    ------------------------------------------------------------------------------
    public int[] insert_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

//    ------------------------------------------------------------------------------
    public int[] bubble_sort(int[] arr) {
        int n = arr.length;
        do {

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

        } while (--n > 1);

        return arr;
    }

//    ------------------------------------------------------------------------------

    public String moveTen(String s) {
        char[] char_arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int new_letter;
            int moved_letter = char_arr[i] + 10;

            if (Character.isUpperCase(char_arr[i])) {
                new_letter = moved_letter > 90 ? 64 + moved_letter % 90 : char_arr[i] + 10;
            } else {
                new_letter = moved_letter > 122 ? 96 + moved_letter % 122 : char_arr[i] + 10;
            }
            char_arr[i] = (char) new_letter;
        }

        System.out.println(char_arr);
        return Arrays.toString(char_arr);
    }

//    ------------------------------------------------------------------------------

    public static char triangle(final String row) {
        HashMap<String,Character> dict = new HashMap<>();
        dict.put("GG",'G');
        dict.put("RR",'R');
        dict.put("BB",'B');
        dict.put("RG",'B');
        dict.put("GR",'B');
        dict.put("BR",'G');
        dict.put("RB",'G');
        dict.put("BG",'R');
        dict.put("GB",'R');
        return helper(row.toCharArray(), row.length(),dict);
    }
    public static char helper(char[] arr, int counter, HashMap<String,Character> dict){
        if(counter==1) return arr[0];
        else{
            for(int i=1;i<counter;i++){
                arr[i-1] = dict.get(String.valueOf(arr[i]) + arr[i - 1]);
            }
            return helper(arr,counter-1,dict);
        }
    }
}
