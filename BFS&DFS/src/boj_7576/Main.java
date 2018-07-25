package boj_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/*토마토 1 -> BFS&DFS*/

public class Main {
    static int x;
    static int y;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] board;
    static int MAX = -987654321;
    static boolean done = true;
    public static void main(String[] args){
        sc.init();
        x = sc.nextInt();
        y = sc.nextInt();
        board = new int[x][y];

        for(int i =0; i < y; i++){
            for(int j = 0; j < x; j++){
                board[j][i] = sc.nextInt();
            }
        }

        BFS();

       check();
     /*   for(int i =0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.print(board[j][i]);
            }
            System.out.println();
        }*/
    }

    static void BFS(){
        Queue<point> q = new LinkedList<point>();
        for(int i =0; i < y; i++){
            for(int j = 0; j < x; j++) {
                if(board[j][i] == 1){
                    q.add(new point(j,i));
                }
            }
        }
        while(!q.isEmpty()){
            point cur = q.poll();
            for(int i = 0; i < 4 ; i ++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) {
                    continue;
                }
                if(board[nextX][nextY] != 0)
                    continue;

                board[nextX][nextY] = board[cur.x][cur.y] + 1;
                q.add(new point(nextX,nextY));
            }
        }
    }

    static void check(){
        for(int i =0; i < y; i++){
            for(int j = 0; j < x; j++) {
                if(board[j][i] == 0){
                    System.out.println("-1");
                    return;
                } else {
                    if(board[j][i] > MAX)
                        MAX = board[j][i];
                }
            }
        }
    System.out.println(MAX - 1);
    }

    static class point{
        int x;
        int y;

        public point(int x, int y){
            this.x = x;
            this.y = y;
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
