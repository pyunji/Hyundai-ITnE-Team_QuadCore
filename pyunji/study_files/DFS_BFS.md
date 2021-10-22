# DFS와 BFS

### 재귀함수

- 자기 자신을 호출하는 함수
- 종료 조건을 반드시 명시해야 함
- **스택과 같은 방식으로 동작**한다

**대표 예제**

- 팩토리얼 계산

  ```java
  public class RecursiveTest2_factorial {
      // 10!을 구해보자
      public static void main(String[] args) {
          System.out.println("5! = " + factorial(5));
      }
      // 5을 인수로 받아서
      // 1 감소한 값을 다음 함수에 인수로 넣어서 호출하고 곱하면 될듯
      public static int factorial(int i) {
          System.out.println("i = " + i);
          // 0! 도 1이기 때문 !
          if (i<=1) return 1;
          return i * factorial(i-1);
      }
  }
  ```

  

- 최대공약수 계산

  - [유클리드 호제법의 아이디어 사용](https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95)

    - A>B인 두 자연수를 나눈 나머지를 R이라고 할 때

    - A와 B의 최대 공약수는 B와 R의 최대 공약수와 같다

      ```java
      public class RecursiveTest3_GCD {
          // 192와 162의 최대 공약수를 구해보자
          public static void main(String[] args) {
              System.out.println("192와 162의 최대 공약수는 : " + GCD(192, 1));
          }
          
          // 유클리드 호제법을 참고하여 문제를 풀어야한다
          public static int GCD(int a, int b) {
              if (a % b == 0) return b;
              return GCD(b, a % b);
          }
      }
      ```

      

## DFS (Depth-First Search)

- **스택 자료구조 또는 재귀함수를 이용**

### 동작 과정

1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 함
2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문 처리함.<br>방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼냄
3. 인접 노드가 여러개일 때 먼저 방문할 기준을 정의해야하고, 알고리즘 문제마다 다름
4. 더이상 2번의 과정을 수행할 수 없을 때 까지 반복