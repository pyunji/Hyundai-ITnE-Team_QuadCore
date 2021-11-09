/* using DFS 
* 1h 소요
*/
class Solution {
    int[] arr;
    int len, answer;
    public int solution(int[] numbers, int target) {
        /* 1. 초기화 작업 */
        arr = numbers;
        len = numbers.length;
        /* 2. 루프를 통해 탐색 시작 -> 이 문제는 0번 인덱스부터 순서대로 노드를 탐색해야 하므로 루프 필요 없음 */
        /* 3. dfs 진입 조건 설정 -> 이 문제는 무조건 0번 인덱스부터 */
        dfs(0, target, 0);
        
        return answer;
    }
    
    public void dfs(int sum, int target, int idx) {
        /* 4. 인덱스 순으로 탐색하기 때문에 방문 처리 필요 없음 */
        /* 5. 탈출 조건 정의 */
        if(idx == len) {
            if(sum==target) {
                answer++;
            }
            return;
        }
        /* 6. 재귀로 탐색할 대상 설정 */
        dfs(sum - arr[idx], target, idx + 1);
        dfs(sum + arr[idx], target, idx + 1);
    }
}