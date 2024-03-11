package test;

import java.util.ArrayList;
import java.util.List;

public class CourseProblem {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(10, 5)),
                        new ArrayList<>(List.of(10, 7)),
                        new ArrayList<>(List.of(4, 35)),
                        new ArrayList<>(List.of(20, 25)),
                        new ArrayList<>(List.of(30, 15)),
                        new ArrayList<>(List.of(22, 34)),
                        new ArrayList<>(List.of(17, 24)),
                        new ArrayList<>(List.of(21, 11)),
                        new ArrayList<>(List.of(32, 12)),
                        new ArrayList<>(List.of(28, 23)),
                        new ArrayList<>(List.of(25, 7)),
                        new ArrayList<>(List.of(13, 5))
                )

        );
        //5->10,13
        //7->10,25
        //35->4
        //25->20
        //15->

        //1-2-3-4-5-7

        int A = 36;
    }
}
