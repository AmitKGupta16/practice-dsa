package com.adv.stack.lecture;

public class StackUsingArray {
    int[] arr = new int[10];
    int top;
    public StackUsingArray() {
        top = -1;
    }

    public void push(int data) {
        if (top == arr.length - 1) return;
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int pop = arr[top];
        top--;
        return pop;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[top];
    }

    public boolean isEmpty() {
        if (top == -1) return true;
        return false;
    }
}
