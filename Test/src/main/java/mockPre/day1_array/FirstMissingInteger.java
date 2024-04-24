package mockPre.day1_array;

//Problem Description
//        Given an unsorted integer array, A of size N. Find the first missing positive integer.
//
//        Note: Your algorithm should run in O(n) time and use constant space.
//
//
//
//        Problem Constraints
//        1 <= N <= 1000000
//
//        -10^9 <= A[i] <= 10^9
//
//
//
//        Input Format
//        First argument is an integer array A.
//
//
//
//        Output Format
//        Return an integer denoting the first missing positive integer.
//
//
//
//        Example Input
//        Input 1:
//
//        [1, 2, 0]
//        Input 2:
//
//        [3, 4, -1, 1]
//        Input 3:
//
//        [-8, -7, -6]
//
//
//        Example Output
//        Output 1:
//
//        3
//        Output 2:
//
//        2
//        Output 3:
//
//        1
//
//
//        Example Explanation
//        Explanation 1:
//
//        A = [1, 2, 0]
//        First positive integer missing from the array is 3.
//        Explanation 2:
//
//        A = [3, 4, -1, 1]
//        First positive integer missing from the array is 2.
//        Explanation 3:
//
//        A = [-8, -7, -6]
//        First positive integer missing from the array is 1.
public class FirstMissingInteger {


    public int firstMissingPositive(int[] A) {
        int arrLength = A.length;
        for(int i=0;i<arrLength;i++) {
            if(A[i]<=0) {
                A[i] = arrLength+2;
            }
        }
        for(int i=0;i<arrLength;i++) {
            int arrEle = Math.abs(A[i]);
            if(arrEle >=1 && arrEle <=arrLength) {
                int idx = arrEle-1;
                A[idx] = -1* Math.abs(A[idx]);
            }
        }
        for(int i=0;i<arrLength;i++) {
            if(A[i] > 0) {
                return i+1;
            }
        }

        return arrLength+1;
    }

    public static int firstMissingPositiveOptimize(int[] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            while (A[i] >= 1 && A[i] <= size
                    && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < size; i++)
            if (A[i] != i + 1)
                return (i + 1);
        return (size + 1);
    }

}
