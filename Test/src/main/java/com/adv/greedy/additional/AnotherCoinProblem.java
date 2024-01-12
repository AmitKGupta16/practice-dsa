package com.adv.greedy.additional;

import java.util.ArrayList;

/*Problem Description
        The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:

        1, 5, 25, 125, 625, 3125, 15625, ...
        Formally, for each K >= 0 there are coins worth 5K.

        Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).



        Problem Constraints
        1 <= A <= 2×10^9



        Input Format
        The only argument given is integer A.



        Output Format
        Return the smallest number of coins necessary to pay exactly the cost of the item.



        Example Input
        Input 1:

        A = 47
        Input 2:

        A = 9


        Example Output
        Output 1:

        7
        Output 2:

        5


        Example Explanation
        Explanation 1:

        Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
        Explanation 2:

        Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).*/

public class AnotherCoinProblem {
    public static void main(String[] args) {
        AnotherCoinProblem anotherCoinProblem = new AnotherCoinProblem();
        anotherCoinProblem.solve(3125);

    }

    public int solve(int A) {
        ArrayList<java.math.BigInteger> list = new ArrayList<>();
        list.add(java.math.BigInteger.ONE);
        for(long  i=5;i <= A; i=i*5) {
            if(i>2000000000) break;
            list.add(java.math.BigInteger.valueOf(i));

        }
        int count =0;
        java.math.BigInteger val = java.math.BigInteger.valueOf(A);
        for(int i =list.size()-1;i >=0 && val.intValue() > 0;i-- ){
            if(list.get(i).compareTo(java.math.BigInteger.valueOf(A)) > 0) {
                break;
            }
           count += val.divide(list.get(i)).intValue();
           val = val.mod(list.get(i));
        }
        return count;
    }


}
