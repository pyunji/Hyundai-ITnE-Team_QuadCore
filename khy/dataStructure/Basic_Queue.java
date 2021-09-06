package problem;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	//offer poll
	class Node<T>{
		private T data;
		private Node<T> nextNode;
		
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
	}

	public Node<T> first;
	public Node<T> last;
	
	public void add(T newValue) {
		Node<T> newNode = new Node<T>();
		newNode.setData(newValue);

		if(last != null) {
			last.nextNode = newNode;
		}
		last = newNode;
		if(first == null) {
			first = last;
		}
		
		
		/*
		if(first == null) {
			first = newNode;
			last = newNode;
		}else {
			last = newNode;
			Node<T> currNode = first;
			
			while(currNode.nextNode!=null) {
				currNode = currNode.nextNode;
			}
			
			currNode.nextNode = newNode;
		}
		*/
	} 
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
			/*
			return null;
			*/
		} else {
			Node<T> currNode = first;
			first = first.nextNode;
			if(first == null) {
				last = null;
			}
			return currNode.getData();
		}
	}
	
	public T peek() {
		if(first==null) {
			throw new NoSuchElementException();
			/*
			return null;
			*/
		}else {
			return first.getData();
		}
	}
	
	public boolean isEmpty() {
		/*
		if(first==null) {
			return true;
		}else {
			return false;
		}
		*/
		return first == null;
	}
	
	
	public static void main(String[] args) {
		MyQueue myq = new MyQueue<Integer>();
		myq.add(1);
		myq.add(2);
		System.out.println("peek():"+myq.peek());
		myq.add(3);
		myq.add(4);
		System.out.println("peek():"+myq.peek());
		System.out.println(myq.remove());
		System.out.println(myq.remove());
		System.out.println("peek():"+myq.peek());
		System.out.println("isEmpty():"+myq.isEmpty());
		System.out.println(myq.remove());
		System.out.println(myq.remove());
		System.out.println("isEmpty():"+myq.isEmpty());
	}
}
