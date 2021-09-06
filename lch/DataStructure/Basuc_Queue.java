import java.security.NoSuchAlgorithmException;

class Queue<T>{     // 데이터 타입 선언
  class Node<T>{   // 같은 타입을 받는 노드 생성
    private T data; // 데이터를 선언
    private Node<T> next; // 다음 노드의 주소 저장

    public Node(T data){ // 생성자에서 해당 데이터를 받음
      this.data = data; // 내부 변수를 저장
    }
  }
    private Node<T> first; //큐는 앞 뒤로 주소를 알아야함으로
    private Node<T> last;  // 선언하고

    public void add(T item){   //추가할 T타입의 데이터를 받아
      Node<T> t = new Node<T>(item); // 그 노드로 데이터를 생성함

      if(last != null){  // 만약 마지막 노드가 있다면
        last.next = t;  //그 뒤에 새로 생성한 노드를 붙임
      }
      last = t; // t가 마지막 노드가 됨
      if(first == null){ // 데이터가 없을 경우에는  첫번째 노드도 널임
         first = last;    // 같은 값을 할당 해줌
      } 
    }
    
    public T remove(){
      if(first == null){   //q가 비어있으면
        throw new NoSuchAlgorithmException();    // 에러를 던짐
      }
      T dat = first.data;  // 데이터 백업
      first = first.next;  

      if(first == null){  //first가 null이 되면 last도 변경 해줘야함
        last = null;
      }
      return data;  
    }

    public T peek(){    // T타입의 데이터 반환
      if(first == null){
        throw new NoSuchAlgorithmException();  
      }
      return first.data; // null이 아니면 first의 데이터를 반환
    }

    public boolean isEmpty(){ 
     return first == null; // first가 널인지 보내본다.
    }
}
public class Test() {
  public static void main(String[] args) {
    Queue<Integer> q = new Queue<Integer>(); // Integer 타입을 사용
    q.add(1);          //q에 데이터 담기
    q.add(5);
    q.add(9);
    q.add(8);
    System.out.println(q.remove());  // 데이터를 꺼내오면서 출력
    System.out.println(q.remove()); 
    System.out.println(q.peek());   // 데이터 확인
    System.out.println(q.isEmpty()); // 비어있는지 확인함 
  }
}