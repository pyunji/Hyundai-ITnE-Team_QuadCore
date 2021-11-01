import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static boolean[][] chk;
    public static Queue<Point> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int answer, row, col;
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int i, int j) {
        chk[i][j] = true;
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int di = 0; di < 8; di++) {
                int nx = x + dx[di];
                int ny = y + dy[di];
                if (nx >= 0 && ny >= 0 && nx < row && ny < col && !chk[nx][ny] && arr[nx][ny] == 1) {
                    q.add(new Point(nx, ny));
                    chk[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while (!(str = br.readLine()).equals("0 0")) {
            answer = 0;
            st= new StringTokenizer(str);
            // 열
            col = Integer.parseInt(st.nextToken());
            // 행
            row = Integer.parseInt(st.nextToken());

            chk = new boolean[row][col];
            // 배열 초기화
            arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // bfs 시작하기
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == 1 && !chk[i][j]) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
