import java.util.EmptyStackException;

public class Mystack<T> {
	class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> top;
	
	public void push(T data) {
		Node<T> newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	public T pop() {
		if(top == null) {
			throw new EmptyStackException();
		}else {
			T data = top.data;
			top = top.next;
			return data;
		}
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}else {
			return top.data;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public static void main(String[] args) {
		 Mystack<Integer> stack = new Mystack();
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 stack.push(4);
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 System.out.println(stack.peek());
		 System.out.println(stack.peek());
		 System.out.println(stack.peek());
		 System.out.println(stack.pop());
		 System.out.println(stack.isEmpty());
	}
}