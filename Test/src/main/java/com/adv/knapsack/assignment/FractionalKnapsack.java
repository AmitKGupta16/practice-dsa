package com.adv.knapsack.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*Problem Description
        Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

        Also given an integer C which represents knapsack capacity.

        Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

        NOTE:

        You can break an item for maximizing the total value of the knapsack


        Problem Constraints
        1 <= N <= 10^5

        1 <= A[i], B[i] <= 10^3

        1 <= C <= 103



        Input Format
        First argument is an integer array A of size N denoting the values on N items.

        Second argument is an integer array B of size N denoting the weights on N items.

        Third argument is an integer C denoting the knapsack capacity.



        Output Format
        Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



        Example Input
        Input 1:

        A = [60, 100, 120]
        B = [10, 20, 30]
        C = 50
        Input 2:

        A = [10, 20, 30, 40]
        B = [12, 13, 15, 19]
        C = 10


        Example Output
        Output 1:

        24000
        Output 2:

        2105


        Example Explanation
        Explanation 1:

        Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
        the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
        Explanation 2:

        Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.*/
public class FractionalKnapsack {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(List.of(16,3,3,6,7,8,17,13,7));
        ArrayList<Integer> B = new ArrayList<>(List.of(3,10,9,18,17,17,6,16,13));
        System.out.println(solve(A,B,11));

    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Item> items = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            items.add(new Item(A.get(i),B.get(i)));
        }

//       List<Item> sortedlist= items.stream().sorted(new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return (int) (o2.getProfitPerUnit() - o1.getProfitPerUnit());
//            }
//        }).collect(Collectors.toList());
        items.sort((a,b) -> b.getProfitPerUnit().compareTo(a.getProfitPerUnit()));
        double ans=0;
        for(int i=0;i<items.size();i++) {
            if(items.get(i).getWeight()>=C) {
                ans += items.get(i).getProfitPerUnit() * C;
                C=0;
                break;
            } else {
                ans+= items.get(i).getValue();
                C = C-items.get(i).getWeight();
            }

        }
        return (int) Double.parseDouble(String.format("%2f", ans * 100));
    }
}


class Item {
    Integer value;
    Integer weight;
    Double profitPerUnit;
    public Item(Integer value,Integer weight){
        this.value =value;
        this.weight = weight;
        this.profitPerUnit = value/(double)weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getProfitPerUnit() {
        return profitPerUnit;
    }

    public void setProfitPerUnit(Double profitPerUnit) {
        this.profitPerUnit = profitPerUnit;
    }
}
