package mockPre.day1_array;

public class SumOfAllSubArray {
    public static void main(String[] args) {
        int[] A ={1,2,3}; //1,2,3, 1,2 , 2,3, 1 ,2, 3
        System.out.println(allSubArraySum(A));

    }
    public static int allSubArraySum(int[] A) {
        int totalSumArraySum =0;
        int length = A.length;
        for (int i=0;i<length;i++) {
            totalSumArraySum += A[i]*(i+1)*(length-i);
        }
        return totalSumArraySum;
    }
}
