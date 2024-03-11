package com.adv.arrays.lecture;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0,4),new Interval(1,4),new Interval(5,6),new Interval(6,8),
        new Interval(7,10),new Interval(8,9),new Interval(12,14)};
        System.out.println(mergeInterval(intervals));

    }

    public static List<Interval> mergeInterval(Interval[] intervals) {
        List<Interval> result = new ArrayList<>();
        int curr_start = intervals[0].start;
        int curr_end = intervals[0].end;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start <= curr_end) {
                curr_end = Math.max(intervals[i].end,curr_end);
            } else {
                result.add(new Interval(curr_start,curr_end));
                curr_start = intervals[i].start;
                curr_end = intervals[i].end;
            }
        }
        result.add(new Interval(curr_start,curr_end));
        return result;
    }
}
class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.end = end;
        this.start =start;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
