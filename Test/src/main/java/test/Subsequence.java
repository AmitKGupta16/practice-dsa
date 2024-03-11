package test;

public class Subsequence {
    public static void main(String[] args) {
        String A ="DAGAGAGB";
        int cnt=0;
        for(int i=0;i<A.length()-1;i++) {
            if(A.charAt(i)=='A') {
                if(i+1 < A.length() && A.charAt(i+1)=='G') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
