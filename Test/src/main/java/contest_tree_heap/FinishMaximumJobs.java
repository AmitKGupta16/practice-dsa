package contest_tree_heap;

import java.util.ArrayList;
import java.util.Comparator;

public class FinishMaximumJobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        ArrayList<PairJob> jobList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            jobList.add(new PairJob(A.get(i), B.get(i)));
        }
        jobList.sort(Comparator.comparingInt(val -> val.endTime));
        int count = 1, endTime = jobList.get(0).endTime;
        for (int i = 1; i < size; i++) {
            if(endTime <= jobList.get(i).startTime) {
                count++;
                endTime = jobList.get(i).endTime;
            }
        }
        return count;
    }
}

class PairJob {
    int startTime;
    int endTime;

    public PairJob(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }
}
