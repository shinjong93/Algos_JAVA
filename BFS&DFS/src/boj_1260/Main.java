package boj_1260;

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

      /*  for(int i = 1; i < y+1; i++){
            for(int j = 1; j < x+1; j++){
                System.out.print(board[j][i]);
            }
            System.out.println();
       } */

        BFS();
        System.out.println(MIN);
    }

    static void BFS(){
        Queue<point> q = new LinkedList<point>();
        q.add(new point(1,1,1));

        while (!q.isEmpty()){
            point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX >= x+1 || nextY >= y+1) {
                    continue;
                }
                if(board[nextX][nextY] != 1)
                    continue;
                if(p.history < MIN) {
                    board[nextX][nextY] = p.history+1;
                    q.add(new point(nextX, nextY, p.history + 1));
                }
            }
            if(p.x == x && p.y == y && p.history < MIN){
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