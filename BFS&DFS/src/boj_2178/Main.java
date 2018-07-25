package boj_2178;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/*백준 2178번 미로찾기 BFS & DFS*/

public class Main {
    static int[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int x;
    static int y;
    static int MIN = 987654321;
    public static void main(String[] args){
        sc.init();
        y = sc.nextInt();
        x = sc.nextInt();
        board = new int[x+1][y+1];

        for(int i = 1; i < y+1; i++){
            String s = sc.readLine();
            for(int j = 1; j < x+1; j++){
                char chr = s.charAt(j-1);
                board[j][i] = (int)chr - 48;
            }
        }

        BFS();
        System.out.println(MIN);
    }

    static void BFS(){
        Queue<point> q = new LinkedList<point>();
        q.add(new point(1,1,1)); // 시작하는 (1,1). 진행한 칸수는 1.

        while (!q.isEmpty()){
            point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX >= x+1 || nextY >= y+1) { // 좌표의 범위 체크
                    continue;
                }
                if(board[nextX][nextY] != 1) // 진행하고자 하는 곳이 0이면 못가는 길, 1보다 클 경우에는 이미 진행했던 길. 고로 1이 아닌 경우에는 진행하지 않음.
                    continue;               //해당부분 추가한 이후 시간 내에 계산 완료되었음.
                if(p.history < MIN) {//최소의 경우의 수가 발견 된 이후에는 탐색이 무필요.
                    board[nextX][nextY] = p.history+1; // 지나온 길까지의 진행 칸수로 대체
                    q.add(new point(nextX, nextY, p.history + 1));//큐에 넣음.
                }
            }
            if(p.x == x && p.y == y && p.history < MIN){//도착지의 좌표이면서, 현재까지 최소의 진행 칸수를 지니고 있다면 변경.
                MIN = p.history;
            }
        }
    }

    static class point{
        int x;
        int y;
        int history;

        public point(int x, int y, int history){
            this.x = x;
            this.y = y;
            this.history = history;
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }

        static String readLineReplace() {
            try {
                return br.readLine().replaceAll("\\s+", "");
            } catch (IOException e) {
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static boolean hasNext() {
            return st.hasMoreTokens();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
