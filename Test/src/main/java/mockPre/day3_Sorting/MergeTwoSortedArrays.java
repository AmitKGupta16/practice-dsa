package mockPre.day3_Sorting;


import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
    Note: A linear time complexity is expected and you should avoid use of any library function.

Problem Constraints
    -2×10^9 <= A[i], B[i] <= 2×10^9
    1 <= |A|, |B| <= 5×10^4

Input Format
    First Argument is a 1-D array representing A.
    Second Argument is also a 1-D array representing B.

Output Format
    Return a 1-D vector which you got after merging A and B.

Example Input
    Input 1:
        A = [4, 7, 9]
        B = [2, 11, 19]
    Input 2:
        A = [1]
        B = [2]

Example Output
    Output 1:
        [2, 4, 7, 9, 11, 19]
    Output 2:
        [1, 2]

Example Explanation
    Explanation 1:
        Merging A and B produces the output as described above.
    Explanation 2:
         Merging A and B produces the output as described above.
* */
public class MergeTwoSortedArrays {

    // https://www.scaler.com/academy/mentee-dashboard/class/126653/assignment/problems/164?navref=cl_tt_lst_nm
    ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B)  {
        ArrayList<Integer> result = new ArrayList<>();
        int lengthA = A.size();
        int lengthB = B.size();
        int indexA =0;
        int indexB=0;
        while (indexA < lengthA && indexB <lengthB) {
            if(A.get(indexA) < B.get(indexB)) {
                result.add(A.get(indexA));
                indexA++;
            }else if (A.get(indexA) > B.get(indexB)) {
                result.add(B.get(indexB));
                indexB++;
            } else {
                result.add(A.get(indexA));
                result.add(B.get(indexB));
                indexA++;
                indexB++;
            }
        }
        while (indexA <lengthA) {
            result.add(A.get(indexA));
            indexA++;
        }
        while (indexB <lengthB) {
            result.add(B.get(indexB));
            indexB++;
        }

        return result;
    }
}
