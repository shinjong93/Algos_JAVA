package boj_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] result;
    static int[] indegree;
    static int N;
    static int M;
    static Queue<Integer> ans;
    static ArrayList<ArrayList<Integer>> edge;

    public static void main(String[] args){
        sc.init();
        N = sc.nextInt();
        M = sc.nextInt();
        indegree = new int[N+1];
        result = new int[N+1];
        edge = new ArrayList<ArrayList<Integer>>();

        Arrays.fill(indegree,0);

        for(int i = 0; i < N+1; i++){
            edge.add(new ArrayList<Integer>());
        }

        for(int i = 1; i < M+1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge.get(a).add(b);
            indegree[b]++;
        }

        solve();
    }

    static void solve(){
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i < N+1; i++) {
            if(indegree[i] == 0){
                q.add(i);
                System.out.print(i + " ");
            }
        }
            while (!q.isEmpty()){
                int curStudent = q.poll();
                for(int each : edge.get(curStudent)){
                    indegree[each]--;
                    if(indegree[each] == 0){
                        q.add(each);
                        System.out.print(each + " ");
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
