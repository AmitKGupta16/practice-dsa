package final_contest;




public class MinimumCostWithNonSkippableChair {
    public static void main(String[] args) {
        int[] A = {6,2,2,1,5};
        int B =0;
        System.out.println(solve(A,B));
    }
    public static int solve(int[] A, int B) {
        int[] cost = new int[A.length];
        cost[0] = A[0];
        if(B==0) cost[1] = A[0]+A[1];
        else cost[1]= A[1];

        for (int i=2;i<A.length;i++) {
            if(i-1 == B) cost[i] = cost[i-1] + A[i]; // cannot skip
            else {
                cost[i] = A[i] + Math.min(cost[i-1],cost[i-2]);
            }
        }
        return Math.min(cost[A.length-1],cost[A.length-2]);

    }
}
