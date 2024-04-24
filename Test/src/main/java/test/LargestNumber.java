package test;

import com.intermediate.sorting.lecture.InsertionSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 30, 34, 5, 9));
        sort(list);
        System.out.println();

    }
    public static void sort (ArrayList<Integer> list) {
        list.sort(((o1, o2) -> (String.valueOf(o2) + o1).compareTo(String.valueOf(o1) + o2)));

    }
}
