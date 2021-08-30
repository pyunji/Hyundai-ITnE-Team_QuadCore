package ycy_0830;

import java.util.*;

class Node{
	String data;
	Node next;
	
	public Node(String data){
		this.data = data;
	}
}

class Stack{
	Node top;
	
	//데이터 제거
	public String pop() {
		if(top == null) {//스택이 비어있을 경우 예외 발생
			throw new EmptyStackException();
		}
		
		String popData = top.data;
		top = top.next;
		return popData;
	}
	
	//데이터 삽입
	public void push(String item) {
		//새로운 노드 만들기
		Node newNode = new Node(item);
		
		newNode.next = top;
		top = newNode;
	}
	
	public String peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
}

public class StackD {
	

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("hello");
		stack.push("world");
		System.out.println(stack.peek()); // world
		System.out.println(stack.isEmpty()); //false
		System.out.println(stack.pop()); //world
		System.out.println(stack.pop()); //hello
		System.out.println(stack.isEmpty()); //true
	}

}
