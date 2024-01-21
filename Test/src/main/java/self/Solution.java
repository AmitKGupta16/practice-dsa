package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        int a = 0, b = 0;

        for (int i = 1; i <= n; i++) {
            a++;
            b++;
            if (a == 3 && b == 5) {
                list.add("FizzBuzz");
                a = 0;
                b = 0;

            } else if (a == 3) {
                list.add("Fizz");
                a = 0;

            } else if (b == 5) {
                list.add("Buzz");
                b = 0;
            } else {
                list.add("" + i);
            }
        }
        return list;
    }
}
