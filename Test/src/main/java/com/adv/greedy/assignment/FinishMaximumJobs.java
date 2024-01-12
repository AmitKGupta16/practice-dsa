package com.adv.greedy.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Problem Description
        There are N jobs to be done, but you can do only one job at a time.

        Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

        Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

        Return the maximum number of jobs you can finish.



        Problem Constraints
        1 <= N <= 10^5

        1 <= A[i] < B[i] <= 109



        Input Format
        The first argument is an integer array A of size N, denoting the start time of the jobs.
        The second argument is an integer array B of size N, denoting the finish time of the jobs.



        Output Format
        Return an integer denoting the maximum number of jobs you can finish.



        Example Input
        Input 1:

        A = [1, 5, 7, 1]
        B = [7, 8, 8, 8]
        Input 2:

        A = [3, 2, 6]
        B = [9, 8, 9]


        Example Output
        Output 1:

        2
        Output 2:

        1


        Example Explanation
        Explanation 1:

        We can finish the job in the period of time: (1, 7) and (7, 8).
        Explanation 2:

        Since all three jobs collide with each other. We can do only 1 job.*/
public class FinishMaximumJobs {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 2, 6));
        ArrayList<Integer> B = new ArrayList<>(List.of(9, 8, 9));
        System.out.println(solve(A,B));


    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<PairJob> list = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            list.add(new PairJob(A.get(i),B.get(i)));
        }
        list = list.stream().sorted((p, p1)-> p.endTime- p1.endTime).collect(java.util.stream.Collectors.toList());
        int ans=1;
        int preJobEnd = list.get(0).endTime;
        for(int i=1;i< A.size();i++) {
            if(preJobEnd <= list.get(i).startTime){
                ans++;
                preJobEnd = list.get(i).endTime;
            }
        }
        return ans;
    }
}
class PairJob {
    int startTime;
    int endTime;
    public PairJob(int startTime, int endTime) {
        this.startTime =startTime;
        this.endTime = endTime;
    }
}

