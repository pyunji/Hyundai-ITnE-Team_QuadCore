package ycy_0906;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class queue_structure {
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue();
		System.out.println(queue.isEmpty());
		queue.add("bbb");
		queue.add("aaa");
		queue.add("ccc");
		queue.add("ddd");
		System.out.println(queue.peek());
		queue.remove();
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println(queue.isEmpty());
	}
}



class Queue<T>{
	
	class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> first;
	Node<T> last;
	
	public void add(T item) {
		Node<T> newNode = new Node(item);
		
		if(last != null) {
			last.next = newNode;
		}
		
		last = newNode;

		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T removeData = first.data;
		//first.next = first;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		
		return removeData;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}