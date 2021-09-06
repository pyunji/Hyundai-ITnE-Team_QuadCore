import java.util.NoSuchElementException;

public class Basic_Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.peek() = " + queue.peek());
    }
}

class Queue<T> {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    Node<T> first;
    Node<T> last;

    void add(T item) {
        Node<T> node = new Node<>(item);
        if (first == null) {
            first = node;
            last = first;
        } else {
        last.next = node;
        last = last.next;
        }
    }

    T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data; // 데이터 백업
        first = first.next;

        if (first==null) {
            last = null;
        }
        return data;
    }

    T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    boolean isEmpty() {
        return first==null;
    }
}
