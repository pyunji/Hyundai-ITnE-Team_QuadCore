package hashTableBasic;

import java.util.*;

class HashTable{
	class Node{
		String key;
		String value;
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		//getter
		public String getValue() {
			return value;
		}
		//setter
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	LinkedList<Node>[] data;//node를 저장할 배열
	/* 생성자 : LinkedList의 크기 지정 */
	public HashTable(int size) {
		this.data = new LinkedList[size];
	}
	
	/* 키를 받아 해시코드로 반환
	 * 키를 받아서 문자열 각 자리에 해당하는 아스키코드값을 모두 더한 값을 해시코드로 반환 */
	public int getHashCode(String key) {
		int hashCode=0;
		for(int i=0; i<key.length(); i++) {
			hashCode += key.charAt(i);
		}
		return hashCode;
	}
	
	/* 해시코드를 받아서 인덱스로 반환  */
	public int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}
	
	/* 배열 방의 노드가 여러개 존재하는 경우 key를 이용해 특정 노드를 반환 */
	public Node searchKey(LinkedList<Node> list, String key) {
		//배열에 노드가 0개일 경우 리턴값 없음.
		if(list == null) return null;
		
		//배열에 노드가 1개이상일 경우 key를 이용해 특정 노드 반환.
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).key.equals(key)) {//노드의 키가 같으면 반환
				return list.get(i);
			}
		}
		//배열에 노드가 없을경우 리턴값 없음
		return null;
	}
	
	//key와 value를 이용해 데이터를 저장.
	public void put(String key, String value) {
		//key, value로 노드 생성
		Node node = new Node(key, value);
		//key 이용해서 해쉬코드 생성
		int hc = getHashCode(key);
		//해쉬코드로 index 생성
		int index = convertToIndex(hc);
		//배열방 가져오기
		LinkedList<Node> list = data[index];
		
		//index에 노드 넣기
		if(list == null) {//리스트가 비었을 경우, LinkedList<Node> 생성 후 넣어준다.
			list = new LinkedList();
			data[index] = list;
			list.add(node);
		}
		Node sameKeyNode = searchKey(list, key);
		if(sameKeyNode == null) {
			list.add(node);
		}else {//같은 키가 있을경우 값을 수정한다.
//			list.remove(list.indexOf(node));
//			list.add(node);
			sameKeyNode.setValue(value);
		}
	}
	
	//key를 가지고 value를 반환
	public String get(String key) {
		//키로 HashCode생성
		int hc = getHashCode(key);
		//hashCode로 index 생성
		int index = convertToIndex(hc);
		//index로 노드리스트 가져옴.
		LinkedList<Node> list = data[index];
		//searhKey로 노드반환
		Node node = searchKey(list,key);
		
		if(node == null) {return null;}
		return node.getValue();
	}
	
}

public class HashTableBasic {

	public static void main(String[] args) {
		HashTable ht = new HashTable(5);
		ht.put("yu", "chaeyeon");
		ht.put("lee", "sk");
		ht.put("kim", "js");
		ht.put("lee", "sb");//중복
		
		System.out.println(ht.get("yu"));
		System.out.println(ht.get("lee"));
		System.out.println(ht.get("kim"));
	}

}
