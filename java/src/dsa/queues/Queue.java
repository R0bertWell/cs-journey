package dsa.queues;

public class Queue {

    int length = 0;
    Node first;
    Node last;

    private static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    public Queue(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Queue(int value){
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public Queue enqueue(int value){
        Node newNode = new Node(value);

        if (this.length > 0) {
            this.last.next = newNode;
        } else {
            this.first = newNode;
        }

        this.last = newNode;
        this.length++;
        return this;
    }

    public Integer dequeue(){
        if(this.length == 0) return null;

        Node temp = this.first;

        this.first = this.first.next;

        if(this.first == null) this.last = null;

        Integer value = temp.value;
        temp.next = null;
        this.length--;
        return value;
    }
}
