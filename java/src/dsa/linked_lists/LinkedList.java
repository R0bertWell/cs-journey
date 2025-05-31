package dsa.linked_lists;

public class LinkedList {

    protected int length = 0;
    public Node head;
    public Node tail;

    private static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node node){
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void push(int value){
        Node newTail = new Node(value);

        if(this.length != 0) {
            this.tail.next = newTail;
        } else {
            this.head = newTail;
        }

        this.tail = newTail;
        this.length++;
    }

    public int pop(){
        if(this.length == 0) return -1;
        int value = tail.value;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;

            while(current.next != tail){
                current = current.next;
            }

            current.next = null;
            this.tail = current;
        }

        this.length--;
        return value;
    }

    public void unshift(int value){
        Node newHead = new Node(value);
        newHead.next = this.head;

        this.head = newHead;
        this.length++;

        if(this.tail == null){
            this.tail = this.head;
        }
    }

    public int shift(){
        if(head == null) return -1;

        int value = head.value;

        head = head.next;
        this.length--;

        if(head == null){
            tail = null;
        }

        return value;
    }

    public Node getFirst(){
        return this.head;
    }

    public Node getLast(){
        return this.tail;
    }

    public Node getByIndex(int index){
        if(index > length - 1) return null;

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }

    public Node get(int value){
        if(this.head == null) return null;

        Node temp = head;
        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public Node set(int index, int value){
//        if(index > length - 1) return null;
//
//        TreeNode temp = head;
//        for(int i = 0; i <= index; i++){
//            if(i == index){
//                temp.data = value;
//                break;
//            }
//            temp = temp.next;
//        }
        Node temp = getByIndex(index);

        if(temp != null) temp.value = value;
        return temp;
    }

    public void insert(int index, int value){
        if (index < 0 || index > length) return;

        if(index == 0) {
            unshift(value);
            return;
        }

        if (index == length) {
            push(value);
            return;
        }

        Node newNode = new Node(value);
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        length++;
    }

    public static int countNodes(Node head){
        if(head == null)
            return 0;

        int size = 1;
        Node current = head;

        while(current.next != null){
            current = current.next;
            size++;
        }

        return size;
    }

    public LinkedList reverseCorrect3() {
        if (head == null || head == tail) return this;

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node next;
        Node prev = null;

        for (int i = 0; i < length; i++) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return this;
    }

    public LinkedList reverseCorrect2() {
        if (head == null || head == tail) return this;

        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Após o loop, previous estará na antiga tail, que é a nova head
        Node temp = head;
        head = tail;
        tail = temp;

        return this;
    }

    public LinkedList reverseCorrect(){
        if(head == tail) return this;

        Node current = this.head;
        Node temp = current.next;
        current.next = null;
        Node newCurrent;

        while(temp.next != null){
            newCurrent = temp.next;
            temp.next = current;
            current = temp;
            temp = newCurrent;
        }

        temp.next = current;
        this.head = temp;

        return this;
    }
    public void reverse(){
        if(this.length < 2) return;

        Node temp = this.head.next;
        Node currentNode = this.head;

        while(currentNode.next != this.tail){
            currentNode = currentNode.next;
        }

        this.tail.next = temp;
        this.head.next = null;
        Node newHead = this.tail;
        currentNode.next = this.head;
        this.tail = this.head;
        this.head = newHead;

    }

    public static void main(String[] args) {
        Node node = new Node(1);
        LinkedList linkedList = new LinkedList(node);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);

        LinkedList linkedListZerada = new LinkedList();
        linkedListZerada.push(2);
        linkedListZerada.push(3);
        linkedListZerada.push(4);

        System.out.println(linkedListZerada.pop());
        System.out.println(linkedListZerada.pop());
        System.out.println(linkedListZerada.pop());
        System.out.println(linkedListZerada.pop());
        System.out.println(linkedListZerada.pop());

        LinkedList linkedListZerada2 = new LinkedList();
        linkedListZerada2.unshift(10);
        linkedListZerada2.unshift(11);
        System.out.println(linkedListZerada2.getByIndex(0));
        linkedListZerada2.getByIndex(1);
        linkedListZerada2.get(11);
        linkedListZerada2.get(10);
        linkedListZerada2.get(5);
        linkedListZerada2.pop();
        linkedListZerada2.set(0, 5);
        linkedListZerada2.pop();
        linkedListZerada2.set(0, 5);
        linkedListZerada2.unshift(10);
        linkedListZerada2.unshift(11);
        linkedListZerada2.pop();
        linkedListZerada2.insert(1, 20);
//        linkedListZerada2.push(14);
//        linkedListZerada2.push(18);
//        linkedListZerada2.push(25);
        linkedListZerada2.reverseCorrect3();

    }
}
