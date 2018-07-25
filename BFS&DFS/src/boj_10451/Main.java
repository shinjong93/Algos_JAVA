package boj_10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int Case;
    static int ans;
    static int N;
    static Node[] A = new Node[1001]; // 아랫수열
    static Node[] B = new Node[1001]; // 윗수열
    static int[] tmp = new int[1001];

    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        while(Case --> 0) {
            N = sc.nextInt();
            for (int i = 1; i < N + 1; i++) {
                A[i] = new Node(i);
                tmp[i] = i;
            }
            Arrays.sort(tmp);
            for(int i = 1 ; i < N+1; i++){

                B[i] = new Node(tmp[i]);
                B[i].next = A[i];
            }
            boolean[] checked = new boolean[N+1];
            for(int i =1; i < N+1;i++){
                if(!checked[i]){
                    System.out.println(checked[i]);
                    solve(checked,i);
                  }
            }
           // System.out.println(ans);
            ans= 0;
        }

    }

    static void solve(boolean[] checked,int idx){
        checked[idx] = true;

        int cur = A[idx];
        int next = B[cur];
        if(!checked[next]){
            solve(checked, next);
        } else {
          //  System.out.println(idx);
            ans++;
            return;
        }
    }

    static class Node{
        Node next;
        int number;
        boolean visit;

        public Node(int number){
            this.visit = false;
            this.number = number;
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
