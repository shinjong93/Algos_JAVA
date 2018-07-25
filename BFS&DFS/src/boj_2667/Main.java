package boj_2667;

/*백준 2667번 문제 단지 번호 붙이기.
* BFS & DFS 문제.
* 단지의 첫 시작 좌표에서 DFS를 실행. 전역 변수 k 값으로 아파트 값을 수정한다.
* 1일 경우에 탐색을 시작하며, 1이 아닌 경우에는 아파트가 없거나 이미 탐색한 아파트이므로 건너 뛴다.
* 단지 번호는 구별을 용이하게 하기 위해 2부터 시작하며, 한 아파트 단지의 탐색이 종료되면 1을 더해준다.
* 모든 탐색이 완료된 이후, 최종적으로는 k-2개의 단지가 존재한다. k-2 길이의 배열을 선언하고,
* 각 아파트 단지의 값이 0이 아닐 경우에, 아파트 단지 번호 - 2를 인덱스로 하여 정답 배열에 넣는다.
* 이후 정렬하여 출력.
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    static int[][] board;
    static int number;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int k = 2;
    static int[] ans;

    public static void main(String[] args){
        sc.init();
        number = sc.nextInt();
        board = new int[number+1][number+1];
        for(int y = 1; y< number+1; y++){
            String s = sc.readLine();
            for(int x= 1; x < number+1; x++) {
                char chr = s.charAt(x-1);
                board[x][y] = (int)chr-48;
            }
        }

        for(int y=  1; y < number+1; y++){
            for(int x = 1; x < number+1; x++){
                if(board[x][y] == 1){
                    DFS(x,y,k);
                    k++;
                }
            }
        }

        ans = new int[k-2];
        for(int y = 1; y< number+1; y++){
            for(int x= 1; x < number+1; x++) {
                if(board[x][y] != 0){
                    ans[board[x][y]-2]++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(k-2);
        for(int i = 0; i < k-2; i++)
            System.out.println(ans[i]);
    }

    static void DFS(int x, int y, int idx){
        board[x][y] = idx;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 1 || nextY < 1 || nextX >= number+1 || nextY >= number+1) {
                continue;
            }
            if(board[nextX][nextY] != 1)
                continue;

            DFS(nextX,nextY,idx);
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
