package mockPre.day4_BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A ={2,4,5,6,8,9};
        int B = 11;
        System.out.println(solve(A,B));
        //solve(A,B);
    }
    public static int solve(int[] A, int B) {
        int start =0, end = A.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) {
                return 1;
            } else if (A[mid] > B) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return 0;
    }
}
