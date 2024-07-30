package com.adv.queue.assignment;

import java.util.Stack;

public class QueueUsingStacks {
    public static Stack<Integer> stackPush;
    public static Stack<Integer> stackPop;

    public QueueUsingStacks() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    static void push(int X) {
        stackPush.add(X);

    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(stackPop.isEmpty()) {
            while(!stackPush.empty()) {
                stackPop.add(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    /** Get the front element of the queue. */
    static int peek() {
        if(stackPop.isEmpty()) {
            while(!stackPush.empty()) {
                stackPop.add(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        if (stackPop.isEmpty() && stackPush.empty()) return true;
        return false;
    }
}
