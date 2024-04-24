package com.adv.greedy.additional;

import java.util.ArrayList;
import java.util.Comparator;

/*
* Problem Description
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.



Problem Constraints
1 <= N <= 10^5

1 <= A[i] < B[i] <= 10^9



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

 Since all three jobs collide with each other. We can do only 1 job.
* */
public class FinishMaximumJobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        ArrayList<PairJob> pairJobs = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            pairJobs.add(new PairJob(A.get(i), B.get(i)));
        }
        pairJobs.sort(Comparator.comparingInt(value -> value.endTime));

        int ans =1, endTime = pairJobs.get(0).endTime;
        for (int i = 1; i < size; i++) {
            if(pairJobs.get(i).startTime >= endTime) {
                ans++;
                endTime = pairJobs.get(i).endTime;
            }

        }
        return ans;
    }
}

class PairJob {
    int startTime;
    int endTime;

    public PairJob(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

