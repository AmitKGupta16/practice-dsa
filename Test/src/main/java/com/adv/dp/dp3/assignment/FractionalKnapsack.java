package com.adv.dp.dp3.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack


Problem Constraints
1 <= N <= 10^5

1 <= A[i], B[i] <= 10^3

1 <= C <= 10^3



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
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        List<Item> itemList = new ArrayList<>();
        int N = A.size();
        for (int i = 0; i < N; i++) {
            itemList.add(new Item(A.get(i), B.get(i)));
        }
        itemList.sort((a, b) -> b.cost.compareTo(a.cost));
        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            if(itemList.get(i).weight <= C) {
                ans += itemList.get(i).value;
                C -= itemList.get(i).weight;
            } else {
                ans += C * itemList.get(i).cost;
                break;
            }

        }
        return (int) Double.parseDouble(String.format("%2f",ans * 100));
    }
}

class Item {
    Integer value;
    Integer weight;
    Double cost;

    public Item(Integer value, Integer weight) {
        this.value = value;
        this.weight = weight;
        this.cost = value / (double) weight;
    }

}
