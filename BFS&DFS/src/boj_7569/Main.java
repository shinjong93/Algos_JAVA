package boj_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*토마토 2 -> DFS&BFS*/

public class Main {
    static int x;
    static int y;
    static int z;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};
    static int[] dz = {1,-1,0,0,0,0};
    static int[][][] board;
    static int MAX = -987654321;
    public static void main(String[] args){
        sc.init();
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        board = new int[x][y][z];

        for(int k = 0; k < z; k++){
            for(int i = 0; i < y; i++){
                for(int j = 0; j < x; j++){
                    board[j][i][k] = sc.nextInt();
                }
            }
        }
        BFS();
        check();
    }

    static void BFS(){
        Queue<point> q = new LinkedList<point>();
        for(int k = 0; k < z; k++){
            for(int i = 0; i < y; i++){
                for(int j = 0; j < x; j++){
                    if(board[j][i][k] == 1){
                        q.add(new point(j,i,k));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            point cur = q.poll();
            for(int i = 0; i < 6 ; i ++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                int nextZ = cur.z + dz[i];

                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y || nextZ < 0 || nextZ >= z) {
                    continue;
                }
                if(board[nextX][nextY][nextZ] != 0)
                    continue;

                board[nextX][nextY][nextZ] = board[cur.x][cur.y][cur.z] + 1;
                q.add(new point(nextX,nextY,nextZ));
            }
        }
    }

    static void check(){
        for(int k = 0; k < z; k++){
            for(int i = 0; i < y; i++){
                for(int j = 0; j < x; j++){
                    if(board[j][i][k] == 0){
                        System.out.println("-1");
                        return;
                    } else {
                        if(board[j][i][k] > MAX)
                            MAX = board[j][i][k];
                    }
                }
            }
        }
        System.out.println(MAX-1);
    }

    static class point{
        int x;
        int y;
        int z;

        public point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
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
