import java.util.EmptyStackException;

class Stack<T> {   // 스택 클래스 생성
  Class Node<T>{   // 같은 타입을 받는 노드 
  private T data;         // data 선언
  private Node<T> next;

  public Node(T data){
      this.data = data;   // 내부변수 저장
    }
  }
  private Node<T> top;   // 멤버변수 선언

  public T pop() {       // 함수 구현
    if (top == null) {
      throw new ExptyStackException();  // 스택이 비어있는 경우 발생
    }

    T item = top.data;   // 데이터 백업
    top = top.next;     
    return item;
  }

  public void push(T item) {        // 추가
    Node<T> t = new Node<T>(item);  // 노드 생성
    t.next = top;
    top = t;                        // 노드가 top이 된다
  }

  public T peek() {                 // T 타입 반환
    if (top == null) {
      throw new ExptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {      // top 인지 null인지 비교
    return top == null;
  }
}

// pop() = 맨 마지막에 넣은 데이터를 가져오면서 지움
// push() = 새로운 데이터를 하나 더 쌓음
// peak() = 맨 마지막 데이터 봄
// isEmpty() = 스택에 데이터가 있는지 확인

public class stack{
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
  }
}
