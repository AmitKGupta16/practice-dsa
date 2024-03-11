package test;

import java.util.HashMap;


public class LRUCache {
    Node h ;
    Node t ;
    HashMap<Integer,Node> hm;
    public LRUCache(){
        hm = new HashMap<>();
        h = new Node(-1);
        t = new Node(-1);
        h.next = t;
        t.prev = h;
    }


    public static void main(String[] args) {


    }

    public void LRU(int d,int cap) {
        if(hm.containsKey(d)) {
            Node data = hm.get(d);
            remove(data);
            addtoTail(data);
        }else {
            if(hm.size()==cap) {
               Node del =  h.next;
               hm.remove(del.data);
               remove(del);
            }
            Node nn = new Node(d);
            addtoTail(nn);
            hm.put(d,nn);

        }
    }

    public void remove(Node del) {
        Node prev = del.prev;
        Node next = del.next;
        prev.next = next;
        next.prev  = prev;
    }

    public void addtoTail(Node add) {
        add.next = t;
        add.prev = t.prev;
        t.prev =add;
        add.prev.next = add;
    }

}

class Node {
    int data;
    Node prev,next;
    public Node(int data){
        this.data =data;
        prev = next =null;
    }
}
