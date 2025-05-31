package dsa.linked_lists;

public class DoubleLinkedList {

    public int length;
    public Node head;
    public Node tail;

    private static class Node {
        public int value;
        public Node next;
        public Node previous;

        public Node(int value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public DoubleLinkedList(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        length = 1;
    }

    public DoubleLinkedList push(int value){
        Node newNode = new Node(value);

        if(this.head != null){
            this.tail.next = newNode;
            newNode.previous = this.tail;
        } else {
            this.head = newNode;
        }

        this.tail = newNode;

        length++;
        return this;
    }

    public Integer pop(){
        if(this.tail == null) return null;

        Node oldTail = this.tail;             // Referência temporária
        this.tail = this.tail.previous;

        if(this.tail != null){
            this.tail.next = null;
        } else {
            this.head = null;
        }

        oldTail.previous = null;
        oldTail.next = null;

        length--;
        return oldTail.value;
    }

    public DoubleLinkedList unshift(int value){
        Node newNode = new Node(value);

        if(this.head != null) {
            this.head.previous = newNode;
            newNode.next = this.head;
        } else {
            this.tail = newNode;
        }

        this.head = newNode;

        length++;
        return this;
    }

    public Integer shift() {
        if (this.head == null) return null;

        Node oldHead = this.head;
        this.head = oldHead.next;

        if (this.head != null) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }

        oldHead.next = null;
        length--;

        return oldHead.value;
    }
    public DoubleLinkedList reverse(){

        Node currNode = this.tail;
        Node newHead = null;
        Node newTail = null;

        while(currNode != null){

            if(currNode.next != null && currNode.previous != null){
                Node temp = currNode.previous;
                currNode.previous = currNode.next;
                currNode.next = temp;
                currNode = temp;
                continue;
            }

            if(currNode == this.tail){
                Node temp = currNode.previous;
                currNode.previous = null;
                currNode.next = temp;
                newHead = currNode;
                currNode = temp;
                continue;
            }

            if(currNode == this.head){
                Node temp = currNode.next;
                currNode.next = null;
                currNode.previous = temp;
                newTail = currNode;
                break;
            }
        }

        this.head = newHead;
        this.tail = newTail;

        return this;
    }

    public DoubleLinkedList reverseTailHead(){
        if(head == tail) return this;

        Node newHead = this.tail;
        Node newTail = this.head;

        Node nextToHead = this.head.next;
        Node previousToTail = this.tail.previous;


        if(head != previousToTail) {
            newHead.previous = null;
            newHead.next = nextToHead;
            nextToHead.previous = newHead;

            newTail.previous = previousToTail;
            newTail.next = null;
            previousToTail.next = newTail;
        } else {
            newHead.previous = null;
            newHead.next = newTail;
            newTail.next = null;
            newTail.previous = newHead;
        }

        this.head = newHead;
        this.tail = newTail;

        return this;
    }


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList(10);
        linkedList.push(20);
        linkedList.unshift(25);
        linkedList.pop();
        linkedList.reverseTailHead();
        System.out.println(linkedList.toString());
    }

}
