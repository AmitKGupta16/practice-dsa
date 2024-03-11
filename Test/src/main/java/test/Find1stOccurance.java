package test;

public class Find1stOccurance {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 4, 4, 5};
        int B = 22;
        System.out.println(firstOcc(A, B));

    }

    public static int firstOcc(int[] A, int B) {
        int len = A.length;
        if (len == 0) return -1;
        //if (len == 1 && A[0] == B) return 0;
        int s = 0, e = len - 1, mid =0;
        int ans =Integer.MAX_VALUE;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (A[mid] >= B) {
                if(A[mid]==B) ans = Math.min(ans,mid);
                e = mid-1;
            } else {
                s = mid + 1;
            }
        }
        return ans==Integer.MAX_VALUE ?-1:ans;
    }
}
