class Solution {
    private boolean[] check;
    int answer = Integer.MAX_VALUE;
    
   public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(begin, target, words, 0);
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int count){
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if (canConvert(begin, words[i]) && !check[i]) {
                check[i] = true;
                dfs(words[i], target, words, count + 1);
                check[i] = false;
            }
        }
    }

    public boolean canConvert(String start, String end) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) count++;
        }
        return count == 1;
    }
}