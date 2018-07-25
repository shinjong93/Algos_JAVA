package boj_1890;

/*백준 1890번 점프 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static long[][] ansBoard;
    static int N;

    public static void main(String[] args){
        sc.init();
        N = sc.nextInt();
        board = new int[N+1][N+1];
        ansBoard = new long[N+1][N+1];

        for(int y =1; y < N+1; y++) {
            for (int x = 1; x < N + 1; x++) {
                board[x][y] = sc.nextInt();
                ansBoard[x][y] = 0;
            }
        }

        solve();

        System.out.println(ansBoard[N][N]);
    }

    static void solve(){
        ansBoard[1][1] = 1;
        for(int y =1; y < N+1; y++){
            for(int x = 1; x < N+1; x++){
                int distance = board[x][y];
                int nextX = x + distance;
                int nextY = y + distance;
                if(ansBoard[x][y] == 0 || (x == N && y == N)){
                    continue;
                } else {
                    if(nextX < N+1){
                        ansBoard[nextX][y] += ansBoard[x][y];
                    }
                    if(nextY < N+1){
                        ansBoard[x][nextY] += ansBoard[x][y];
                    }
                }
            }
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
