package com.adv.arrays;

import java.util.ArrayList;

public class MergeInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        ArrayList<Interval> result = new  ArrayList<Interval>();
        for(Interval current : intervals) {
            if(current.end < newInterval.start) {
                result.add(current);
            } else if(current.end > newInterval.start) {
                newInterval.start = Math.min(current.start,newInterval.start);
                newInterval.end = Math.max(current.end,newInterval.end);
            }
        }
        result.add(newInterval);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval val = new Interval(1,2);
        Interval val1 = new Interval(4,6);
        Interval val2 = new Interval(7,8);
        Interval val3 = new Interval(9,10);
        intervals.add(val);
        intervals.add(val1);
        intervals.add(val2);
        intervals.add(val3);
        Interval newInterval = new Interval(5,8);
        ArrayList<Interval> res = insert(intervals,newInterval);
        for (Interval ss:  res) {
            System.out.print(ss.start + " - " +ss.end + ",");
        }
    }
}
