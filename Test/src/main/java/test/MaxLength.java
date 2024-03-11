package test;

public class MaxLength {
    public static void main(String[] args) {
        int[] A = {-1,6,7,9,4,-3,5,2};
        int startIndex =-1;
        int endIndex =-1;
        int ans=0;
        int currAns =0,maxAns=0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>=0) currAns++;
            else {
                maxAns = Math.max(currAns,maxAns);
                currAns=0;
            }

            if(A[i] >= 0 && startIndex ==-1 && endIndex ==-1) startIndex =i;
            if(A[i] >= 0 && startIndex !=-1) endIndex=i;
            else {
                startIndex=-1;
                endIndex=-1;
            }
            if(startIndex > 0 && endIndex > 0) ans = Math.max(ans,endIndex-startIndex+1);
        }
        System.out.println(ans);
        System.out.println(maxAns);
    }
}
