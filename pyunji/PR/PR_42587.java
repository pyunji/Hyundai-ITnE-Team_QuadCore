class Solution {
    public int solution(int[] priorities, int location) {
        Integer[] priOrdArr = new Integer[priorities.length]; // 객체 배열만 Comparator에 정의된 정렬기준을 사용할 수 있어서 인티저 배열로 변환함
        Queue<Integer> priQueue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            priOrdArr[i] = priorities[i];
            // priorities queue
            priQueue.offer(priorities[i]);

            // 문서의 위치를 나타내는 인덱스 배열 생성 queue
            idxQueue.offer(i);
        }
        // 우선순위 높은 순 정렬한 배열 생성 -> IntegerArray로 변환 후 역순 정렬
        Arrays.sort(priOrdArr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(priOrdArr));
        int count = 0;
        // priority와 인덱스의 순서 변동은 동시에 일어나게 설정
        for (Integer ord : priOrdArr) {
            count++;
            while (!ord.equals(priQueue.peek())) {
                priQueue.offer(priQueue.poll());
                idxQueue.offer(idxQueue.poll());
            }
            priQueue.poll();
            if (idxQueue.poll() == location) {
                break;
            }
        }
        return count;
    }
}