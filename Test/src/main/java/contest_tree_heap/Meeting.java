package contest_tree_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Meeting {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(16,17,16,17,19,27));
        ArrayList<Integer> B = new ArrayList<>(List.of(21,21,17,18,28,34));
        System.out.println(solve(A,B));

    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if((A == null || A.isEmpty()) || (B==null || B.isEmpty())) return 0;
        List<MeetingJob> list = new ArrayList<MeetingJob>();
        int size = A.size();
        for(int i=0;i<size;i++) {
            list.add(new MeetingJob(A.get(i),B.get(i)));
        }
        list.sort(Comparator.comparingInt(meeting-> meeting.startTime));
        PriorityQueue<Integer> roomSize = new PriorityQueue<>();
        roomSize.offer(list.get(0).endTime);


        for(int i=1;i<size;i++) {
            if(list.get(i).startTime >= roomSize.peek()) {
                roomSize.poll();
            }
            roomSize.offer(list.get(i).endTime);
        }
        return roomSize.size();
    }
}

class MeetingJob {
    int startTime;
    int endTime;
    public MeetingJob(int startTime,int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
