package dsa.stacks;

public class Stack {
    private int[] pile;
    private int length;
    private int CAPACITY = 10;

    public Stack(){
        this.pile = new int[this.CAPACITY];
    }

    public Stack(int capacity){
        this.CAPACITY = capacity;
        this.pile = new int[this.CAPACITY];
    }

    public void push(int value){
        if(this.length == this.CAPACITY){
            expand();
        }

        this.pile[this.length] = value;
        this.length++;
    }

    public Integer pop() throws EmptyStackException {
        if(this.length == 0) throw new EmptyStackException("Pilha está vazia");

        int value = this.pile[this.length - 1];
        this.length--;

        if((this.length < this.CAPACITY / 2) && this.CAPACITY > 10){
            shrink();
        }

        return value;
    }

    public void expand(){
        this.CAPACITY *=2;
        int[] newArray = new int[this.CAPACITY];

        for(int i = 0; i < this.length; i++){
            newArray[i] = this.pile[i];
        }

        this.pile = newArray;
    }

    public void shrink(){
        this.CAPACITY /= 2;
        int[] newArray = new int[this.CAPACITY];
        for(int i = 0; i < this.length; i++){
            newArray[i] = this.pile[i];
        }

        this.pile = newArray;
    }

    public int peek(){
        if(this.length == 0) return -1;

        return this.pile[this.length - 1];
    }

    public int capacity(){
        return this.pile.length;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        System.out.println(stack.length);
        System.out.println(stack.capacity());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.length);
        System.out.println(stack.capacity());
        System.out.println(stack.peek());
        stack.push(5454);
        stack.push(5555);
        stack.push(5151554);
        System.out.println(stack.length);
        System.out.println(stack.capacity());
        System.out.println(stack.peek());
    }
}
