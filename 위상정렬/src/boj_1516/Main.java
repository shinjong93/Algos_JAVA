package boj_1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Case;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> edge;
    static Node[] building;
    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        indegree = new int[Case+1];
        building = new Node[Case+1];
        edge = new ArrayList<ArrayList<Integer>>();

        for(int i =0; i < Case + 1; i++){
            edge.add(new ArrayList<>());
            building[i] = new Node(0);
        }

        for(int i = 1; i < Case+1; i++){
            int input =sc.nextInt();
            building[i].time = input;
            while(input != -1){
                input = sc.nextInt();
                if(input ==  -1) break;
                edge.get(i).add(input);
                indegree[i]++;
            }
        }

        solve();

        for(int i = 1; i < Case+1; i++){
            for(int each : edge.get(i)){
                System.out.print(each + " ");
            }
            System.out.println();
            //System.out.println(building[i].getTime());
        }

    }

    static void solve(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < Case+1; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            Node curNode = building[cur];
            int curTime = curNode.time;
            for(int each : edge.get(cur)){
                indegree[each]--;
                building[each].cal(curTime);
                if(indegree[each] == 0)
                    q.add(each);
            }
        }
    }

   static class Node{
        int time;
        int min;
        ArrayList<Node> require;

        public Node(int time){
            this.time = time;
            require = new ArrayList<>();
            min = -1;
        }

        public void add(Node n){
           require.add(n);
        }

        public void cal(int input){
            min = Math.max(input,min);
        }

        public int getTime(){
            return time+min;
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
