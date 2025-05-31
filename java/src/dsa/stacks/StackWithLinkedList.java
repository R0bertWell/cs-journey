package dsa.stacks;

public class StackWithLinkedList {

    public int length;
    public Node top;

    protected static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    public StackWithLinkedList(){
        this.length = 0;
        this.top = null;
    }

    public StackWithLinkedList(int value){
        this.top = new Node(value);
        this.length = 1;
    }

    public StackWithLinkedList push(int value){
        Node newNode = new Node(value);

//        TreeNode temp = null;
//        if(this.top != null){
//            temp = this.top;
//        }

        newNode.next = this.top;
        this.top = newNode;

        this.length++;
        return this;
    }

    public Integer getTop(){
        if(this.top == null) return null;
        return this.top.value;
    }


    public Integer pop(){
        if (this.top == null) return null;
        Node temp = this.top;

        this.top = temp.next;
        temp.next = null;
        this.length--;

        return temp.value;
    }

    public Integer min() {
        if(this.length == 0) return null;

        Node current = this.top;
        int currentMin = Integer.MAX_VALUE;

        while(current != null){
            currentMin = Math.min(currentMin, current.value);
            current = current.next;
        }

        return currentMin;
    }

    public void percurr(){
        Node temp = top;
        StringBuilder str = new StringBuilder();
        str.append("{");
        while(temp != null){
            str.append(temp.value);
            temp = temp.next;

            if(temp != null){
                str.append(",");
            }
        }
        str.append("}");
        System.out.println(str);
    }

    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();

        System.out.println(stack.getTop());
        stack.percurr();
        System.out.println(stack.pop());
        stack.percurr();
        System.out.println(stack.push(1));
        stack.percurr();
        System.out.println(stack.push(2));
        stack.percurr();
        System.out.println(stack.getTop());
        stack.percurr();
        System.out.println(stack.pop());
        stack.percurr();
        System.out.println(stack.getTop());
        stack.percurr();
        System.out.println(stack.pop());
        stack.percurr();
        System.out.println(stack.getTop());
        stack.percurr();
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));
        System.out.println(stack.push(6));
        System.out.println(stack.push(7));
        stack.percurr();
    }
}
