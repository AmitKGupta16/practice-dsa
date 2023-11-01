package com.adv.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MergeOverappingInterval {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval interval) {
        intervals.sort((o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else {
                return 0;
            }
        });
        Map map = new HashMap();

        ArrayList<Interval> list = new ArrayList<Interval>();
        int curr_start = interval.start;
        int curr_end = interval.end;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start <= curr_end) {//|| intervals.get(i).end >= curr_start ) {
                curr_end = Math.max(curr_end, intervals.get(i).end);
                curr_start = Math.min(curr_start,intervals.get(i).start);
            } else {
                Interval iv = new Interval(curr_start, curr_end);
                list.add(iv);
                curr_start = intervals.get(i).start;
                curr_end = intervals.get(i).end;
            }
        }
        Interval is = new Interval(curr_start, curr_end);
        list.add(is);
        return list;
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
        ArrayList<Interval> res = merge(intervals,newInterval);
        for (Interval ss:  res) {
            System.out.print(ss.start + " - " +ss.end + ",");
        }
    }
}
