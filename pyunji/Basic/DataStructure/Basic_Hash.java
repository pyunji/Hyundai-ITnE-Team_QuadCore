import java.util.LinkedList;

public class Basic_Hash {
    public static void main(String[] args) {
        HashTable ht = new HashTable(3);
        ht.put("pyunji", "member1");
        ht.put("chaeyeon4u", "member2");
        ht.put("leechang4", "member3");
        ht.put("hyk339", "member4");
        ht.put("pyunji", "member5");
        System.out.println("ht.get(\"pyunji\") = " + ht.get("pyunji")); // member5
        System.out.println("ht.get(\"chaechae\") = " + ht.get("chaechae")); // Not founc
    }
}

// key와 value를 가지는 Node 객체를 만드는 클래스
class Node {
    String key;
    String value;
    // constructor
    Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
    // getter
    String value() {
        return this.value;
    }
    // setter
    void value(String value) {
        this.value = value;
    }
}

class HashTable {
    // 배열방 만들기
    LinkedList<Node>[] data;
    // constructor
    HashTable(int size) {
        data = new LinkedList[size];
    }
    // key -> hashcode
    int getHashCode(String key) {
        int hashcode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashcode += key.charAt(i);
        }
        return hashcode;
    }
    // hashcode -> 배열방 index
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }
    // index에 해당하는 배열방에서 키로 node를 찾는다
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) { return node; }
        }
        return null;
    }
    void put(String key, String value) {
        Node newNode = new Node(key, value);
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        // 인덱스에 해당하는 데이터가 없으면
        if (list == null) {
            // 새로운 데이터 목록을 만들고
            list = new LinkedList<>();
            // 새로운 데이터를 넣고
            list.add(newNode);
            // 인덱스에 할당
            data[index] = list;
        } else {    // 인덱스에 해당하는 데이터 목록이 있으면
            // 키로 데이터를 찾음
            Node oldNode = searchKey(list, key);
            // 해당 키를 갖고 있지 않으면
            if (oldNode == null) {
                list.add(newNode);
            // 해당 키를 갖고 있으면
            } else {
                oldNode.value(value);
            }
        }
    }
    String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node==null ? "Not found": node.value();
    }
}