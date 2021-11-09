/**
 * using BFS
 * 2h 소요
 */
import java.io.*;
import java.util.*;

/**
 * dfs로 풀 수 없는 문제인 것 같다
 * bfs를 동시에 진입하는 요소가 2개 이상인 경우의 문제로 분류하자
 */
public class Main {
    static int[][] arr, chk;
    static int countTomatoes; // 안 익은 토마토의 개수
    static int[] dRows = {0, 0, -1, 1};
    static int[] dCols = {-1, 1, 0, 0};
    static int row, col;
    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static Queue<Point> q = new LinkedList<>();

    private static void bfs() {
        while (!q.isEmpty()) {
            Point point = q.poll();
            // 둠칫둠칫
            for (int i = 0; i < 4; i++) {
                int nRow = point.row + dRows[i];
                int nCol = point.col + dCols[i];
                if (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col
                        && arr[nRow][nCol] == 0
                        && chk[nRow][nCol] == 0) {
                    q.add(new Point(nRow, nCol)); // 안 익은 토마토를 큐에 넣어서 익은 토마토의 의미를 갖게함
                    chk[nRow][nCol] = chk[point.row][point.col] + 1; // 며칠째인지 체크해줌
                    countTomatoes--; // 토마토 익었다고 해줌
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        chk = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) countTomatoes++;
            }
        }
        // 안 익은 토마토가 없을 경우 리턴
        if (countTomatoes == 0) {
            System.out.println(0);
            return;
        }

        int answer = -1; // 토마토가 모두 익지는 못할 경우를 디폴트로

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Point(i, j)); // 익은 토마토를 큐에 넣어줌
                    chk[i][j] = 1; // 원래 0일이 지난 것으로 체크해야되지만, false의 의미와 겹쳐서 1일 지난걸로 체크
                }
            }
        }

        /* BFS */
        bfs();

        if (countTomatoes == 0) { // 토마토가 다 익었으면
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    answer = Math.max(answer, chk[i][j]); // 며칠 걸렸는지 가져오기
                }
            }
            answer--; // 아까 0대신 1을 넣었으니까 1을 빼줌
        }
        // 토마토가 모두 익지는 못했으면 여전히 answer는 -1임
        System.out.println(answer);
    }
}