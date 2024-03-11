package com.intermediate.carryForward.lecture;

/*
 * Given a string s of lower characters, return count of pairs (i,j) such that i<j and
 * s[i] ='a', s[j]='g'.
 *
 * */
public class CarryForward {
    public static void main(String[] args) {
        String input = "abegag";
        int N = input.length();
        //brute force approach
        int cnt =0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'a') {
                for (int j = i + 1; j < N; j++) {
                    if(input.charAt(j)=='g') cnt++;

                }
            }
        }
        System.out.println(cnt);
        System.out.println(countCombination(input));
    }

    //optimized approach
    public static int countCombination(String input) {
        int ans=0,cnt=0;
        int N=input.length();
        for(int idx =0;idx<N;idx++){
            if(input.charAt(idx)=='a') cnt++;
            else if(input.charAt(idx)=='g') ans+=cnt;
        }
        return ans;
    }
}
