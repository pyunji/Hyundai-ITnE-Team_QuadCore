package basic;

import java.util.*;

public class HashTable {
	class Node {
		String key, value;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	LinkedList<Node>[] data;

	public HashTable(int size) {
		this.data = new LinkedList[size];
	}

	public int getHashCode(String key) {
		int HashCode = 0;
		for (int i = 0; i < key.length(); i++) {
			HashCode += key.charAt(i);
		}
		return HashCode;
	}

	public int convertToIndex(int HashCode) {
		return HashCode % data.length;
	}

	public Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}

	public void put(String key, String value) {
		Node Node = new Node(key, value);
		int HashCode = getHashCode(key);
		int index = convertToIndex(HashCode);
		LinkedList<Node> list = data[index];

		if (list == null) {
			list = new LinkedList<>();
			data[index] = list;
			list.add(Node);
		}
		Node sameKey = searchKey(list, key);
		if (sameKey == null) {
			list.add(Node);
		} else {
			sameKey.setValue(value);
		}
	}

	public String get(String key) {
		int HashCode = getHashCode(key);
		int index = convertToIndex(HashCode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		return node == null ? "not found" : node.getValue();
	}

}
