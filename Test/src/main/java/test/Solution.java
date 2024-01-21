package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(19,25,18,18,22,26));
        ArrayList<Integer> B = new ArrayList<>(List.of(27,32,25,27,23,37));
        solve(A,B);
    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> res = new ArrayList();

        for(int i=0;i<A.size();i++) {
            res.add(new Pair(A.get(i),B.get(i)));

        }
        // List<Pair> res1 = res.stream().sorted(new Comparator<Pair>() {
        //     @Override
        //     public int compare(Pair A, Pair B) {
        //         return A.end - B.end;
        //     }

        // }).collect(java.util.stream.Collectors.toList());

        Collections.sort(res,new Comparator<Pair>() {
            @Override
            public int compare(Pair A, Pair B) {
                if(A.end < B.end) {
                    return -1;
                }
                else if(A.end > B.end) {
                    return 1;
                } else {
                    return 0;
                }
                //return A.end - B.end;
            }

        });

        int ans =1;
        int prevMeetingEnd = res.get(0).end;

        for(int i=1;i<res.size();i++){
            if(res.get(i).start >= prevMeetingEnd) {
                ans=ans+1;
                prevMeetingEnd = res.get(i).end;
            }
        }


        return ans;
    }
}

class Pair {
    public int start;
    public int end;
    public Pair(int start,int end) {
        this.start=start;
        this.end=end;
    }
}


