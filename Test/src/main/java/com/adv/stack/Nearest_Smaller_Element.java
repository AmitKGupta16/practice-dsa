package com.adv.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Nearest_Smaller_Element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            while(!stack.empty() && stack.peek() >= A.get(i)){
                stack.pop();
            }
            if(stack.empty()) {
                res.add(-1);
            } else {
                res.add(A.get(i));
            }
            stack.push(A.get(i));
        }
        return res;
    }
}
