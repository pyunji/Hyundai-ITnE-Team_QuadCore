package problem;

import java.io.*;
import java.util.*;

public class Basic_Hash {
	public static void main(String[] args) {
		MyHashTable mht = new MyHashTable(3);
		mht.put("key1", "value1");
		mht.put("key2", "value2");
		mht.put("key3", "value3");
		System.out.println(mht.get("key1"));
		System.out.println(mht.get("key2"));
		System.out.println(mht.get("key3"));
	}
}

class MyHashTable{
	class Node{
		String key;
		String value;
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		String value() {
			return this.value;
		}
		void value(String value) {
			this.value = value;
		}
	}
	
	LinkedList<Node>[] data;
	
	MyHashTable(int size){
		this.data = new LinkedList[size];
	}
	
	int getHashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode +=	c;
		}
		return hashcode;
	}
	
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	Node searchKey(LinkedList<Node> list, String key) {
		if(list == null) return null;
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, String value) {
		int hash = getHashCode(key);
		int index = convertToIndex(hash);
		LinkedList<Node> list = data[index];
		if(list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		Node node = searchKey(list,key);
		if(node ==null) {
			list.addLast(new Node(key,value));
		} else {
			node.value(value);
		}
	}
	
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		return node == null? "not found" : node.value();
	}
	
}
