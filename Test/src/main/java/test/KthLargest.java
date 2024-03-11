package test;

public class KthLargest {
    public static void main(String[] args) {
        int[] A ={1,2,3,4,5,6,7};
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            if(A[i] > first) {
                second = first;
                third = second;
                first = A[i];

            }
           else if(A[i] > second && A[i]!=first) {
                third = second;
                second = A[i];

            }
           else if(A[i] > third && A[i] != second){
                third =A[i];
            }
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
