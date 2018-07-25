package boj_1325;

/*백준 1325번 효율적인 해킹
깊이 우선 탐색으로 실시.
새로운 컴퓨터를 첫 컴퓨터로 설정할 때 마다 방문 결과를 초기화해야함.
방문하지 않았다면 방문했다고 설정한뒤 해킹된 수++
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> arr[];
    static int[] answer;
    static boolean[] visit;
    static int N;
    static int M;
    static int MAX = -1;

    public static void main(String[] args) {
        sc.init();
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N+1];
        answer = new int[10001];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            arr[A].add(B);
        }
        for(int i = 1; i<=N; i++ ){
            visit = new boolean[N+1];
            dfs(i);
        }

        for(int i= 1; i<= N; i++){
            if(MAX < answer[i])
                MAX = answer[i];
        }

        for(int i= 1; i <= N; i++){
            if(answer[i]==MAX){
                System.out.print(i + " ");
            }
        }
}

    static void dfs(int k){
        visit[k] = true;
        for(int next : arr[k]) {
            if (!visit[next]) {
                dfs(next);
                answer[next]++;
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
