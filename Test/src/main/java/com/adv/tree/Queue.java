/*
package com.adv.tree;


public class Queue<E> {
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Object[] data ={};

    public Queue(int capacity){
        this.capacity = capacity;
        front=0;rear=-1;size=0;
        data = new Object[capacity];
    }

    public void enqueue(Object val) {
        if((rear+1) % capacity == front) {
            return;
        }
        rear = (rear+1) % capacity;
        size++;
        data[rear] = val;

    }
    public Object front(){
        if(size==0) {
            return -1;
        }
        return data[front];
    }

    public void dequeue() {
        if(size==0){
            return;
        }
        //int temp = data[front];
        size--;
        front = (front+1) % capacity;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }
}
*/
