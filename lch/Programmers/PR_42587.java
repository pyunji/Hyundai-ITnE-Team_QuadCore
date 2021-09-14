class Solution {
  public int solution(int[] priorities, int location) {
      Integer[] priArr = new Integer[priorities.length]; 
      Queue<Integer> priQ = new LinkedList<>();
      Queue<Integer> idxQ = new LinkedList<>();
      for (int i = 0; i < priorities.length; i++) {
          priArr[i] = priorities[i];
          priQ.offer(priorities[i]);
          idxQ.offer(i);
      }
      Arrays.sort(priArr, Comparator.reverseOrder());
      System.out.println(Arrays.toString(priArr));
      int count = 0;
      for (Integer ord : priArr) {
          count++;
          while (!ord.equals(priQ.peek())) {
              priQ.offer(priQ.poll());
              idxQ.offer(idxQ.poll());
          }
          priQ.poll();
          if (idxQ.poll() == location) {
              break;
          }
      }
      return count;
  }
}