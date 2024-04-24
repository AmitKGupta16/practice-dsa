package com.adv.stack.lecture;

import java.util.Stack;

//input abbcd - output - acd
//input abccbd - output - ad
public class ConsecutiveElementTillPair {
    public static void main(String[] args) {
        String input = "abccbd";
        String output = removePair(input);
        System.out.println(output);

    }

    public static String removePair(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        for(char ch : A.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.reverse().toString();
    }
}
