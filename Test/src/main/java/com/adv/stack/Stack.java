package com.adv.stack;

import java.util.Arrays;

public class Stack {
   static int top=-1;
   static int capacity = 100;
   static char[] arr = new char[capacity];

    public static boolean isEmpty() {
        if(top==-1) {
            return true;
        }
        return false;
    }

    public static char peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return '0';
    }
    public static void push(char ch) {
        if(!(top== arr.length-1)) {
            top++;
            arr[top] = ch;
        }
    }
    public static void pop() {
        if(!isEmpty()) {
            top--;
        }
    }
    public static int solve(String A) {
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)=='(' || A.charAt(i)=='{' || A.charAt(i)=='[') {
                push(A.charAt(i));
            } else {
                if(A.charAt(i)==')') {
                    if(isEmpty() || peek()!=')'){
                        return 0;
                    }
                    pop();
                }
                if(A.charAt(i)=='}') {
                    if(isEmpty() || peek()!='}'){
                        return 0;
                    }
                    pop();
                }
                if(A.charAt(i)==']') {
                    if(isEmpty() || peek()!=']'){
                        return 0;
                    }
                    pop();
                }
            }
        }
        if(isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "{([])}";
        System.out.println(solve(A));

    }
}
