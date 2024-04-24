package mockPre.day1_array;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {


    }

    public int maxSumOfSubArr(int[] A) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            currSum += A[i];
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
