import java.util.EmptyStackException;

public class Basic_Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("e");
        stack.push("d");
        stack.push("c");
        stack.push("b");
        stack.push("a");

        System.out.println("stack.peek() = " + stack.peek()); //stack.peek() = a
        System.out.println("stack.pop() = " + stack.pop()); // stack.pop() = a
        System.out.println("stack.peek() = " + stack.peek()); // stack.peek() = b
        System.out.println("stack.pop() = " + stack.pop()); // stack.pop() = b
        System.out.println("stack.peek() = " + stack.peek()); // stack.peek() = c
        System.out.println("stack.pop() = " + stack.pop()); // stack.pop() = c
        System.out.println("stack.peek() = " + stack.peek()); // stack.peek() = d
        System.out.println("stack.pop() = " + stack.pop()); // stack.pop() = d
        System.out.println("stack.peek() = " + stack.peek()); // stack.peek() = e
        System.out.println("stack.pop() = " + stack.pop()); // stack.pop() = e
        System.out.println("stack.peek() = " + stack.peek()); // EmptyStackException

    }
}

class Stack {
    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    Node top;

    public String pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public String peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void push(String item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
    }

    public boolean isEmpty() {
        return top == null;
    }
}