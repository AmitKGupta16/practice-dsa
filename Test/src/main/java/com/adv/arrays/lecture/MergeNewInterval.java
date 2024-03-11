package com.adv.arrays.lecture;

import java.util.ArrayList;
import java.util.List;

public class MergeNewInterval {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0,4),new Interval(1,4),new Interval(5,6),new Interval(6,8),
                new Interval(7,10),new Interval(8,9),new Interval(12,14)};
        System.out.println(mergeNewInterval(intervals,new Interval(13,15)));
    }

    public static List<Interval> mergeNewInterval(Interval[] intervals, Interval interval) {
        List<Interval> result = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            if(interval.start < intervals[i].end) {
                result.add(new Interval(intervals[i].start,intervals[i].end));
            } else if(interval.end > intervals[i].start) {
                result.add(interval);
                for(int j=i;j<intervals.length;j++) {
                    result.add(new Interval(intervals[i].start,intervals[i].end));
                }
            } else {
                interval.start = Math.min(intervals[i].start,interval.start);
                interval.end = Math.max(intervals[i].end,interval.end);
            }
        }

        return  result;

    }
}
