package com.adv.arrays.lecture;

import java.util.ArrayList;
import java.util.List;

public class MergeMyInterval {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0,4),new Interval(1,4),new Interval(5,6),new Interval(6,8),
                new Interval(7,10),new Interval(8,9),new Interval(12,14)};
        Interval[] intervals1 = {new Interval(1,3),new Interval(6,9)};
        Interval newInterval =  new Interval(2,6);
        ArrayList<Interval> input = new ArrayList<>(List.of(intervals));
        ArrayList<Interval> input1 = new ArrayList<>(List.of(intervals1));
       // System.out.println(mergeMyInterval(input));
        System.out.println(mergeMyInterval(input1,newInterval));
    }


    public static ArrayList<Interval> mergeMyInterval(ArrayList<Interval> intervals,Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        //Interval curr = intervals.get(0);
        for(int i=0;i<intervals.size();i++) {
            if(intervals.get(i).end < newInterval.start) {  // agage
                result.add(intervals.get(i));
            } else if(newInterval.end < intervals.get(i).start) {
                result.add(newInterval);
                newInterval = intervals.get(i);
            }
            else if (intervals.get(i).end >= newInterval.start){
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            }
        }
        result.add(newInterval);
        return result;

    }















    public static ArrayList<Interval> mergeMyInterval(ArrayList<Interval> intervals) {

        ArrayList<Interval> result = new ArrayList<>();
        Interval curr = intervals.get(0);
        for(int index =1;index < intervals.size();index++) {
            if(curr.end >= intervals.get(index).start || curr.end <= intervals.get(index).start ){
                curr.end = Math.max(curr.end, intervals.get(index).end);
                curr.start = Math.min(curr.start, intervals.get(index).start);
            } else {
                result.add(curr);
                curr = intervals.get(index);
            }
        }
        result.add(curr);
        return result;

    }
}
