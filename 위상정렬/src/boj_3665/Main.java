package boj_3665;

/*
* 일관성이 없다 -> 발표자료를 반영한 이후, 한팀 이상 차수가 0보다 작아져있다.
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int Case;
    static int numberOfTeam;
    static int[][] teams;
    static int[] indegree;
    static Queue<Integer> sorted;
    static int change;

    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        while(Case --> 0){
            numberOfTeam = sc.nextInt();
            teams = new int[numberOfTeam + 1][numberOfTeam+1];
            sorted = new LinkedList<Integer>();
            indegree = new int[numberOfTeam+1];
            int[] tmp = new int[numberOfTeam+1];
            for(int i = 1; i < numberOfTeam+1; i++){
                int number = sc.nextInt();
                tmp[i] = number;
            }

            for(int i = 1; i < numberOfTeam + 1; i++){
                for(int j = i+1; j < numberOfTeam+1; j++){
                    int a = tmp[i];
                    int b = tmp[j];
                    teams[a][b] = 1;
                    indegree[b]++;
                }
            }

            change = sc.nextInt();
            while(change --> 0){
                int high = sc.nextInt();
                int low = sc.nextInt();

                if(teams[high][low] == 1){
                    teams[low][high] = 1;
                    teams[high][low] = 0;
                    indegree[low]--;
                    indegree[high]++;
                } else {
                    teams[low][high] = 0;
                    teams[high][low] = 1;
                    indegree[low]++;
                    indegree[high]--;
                }

            }

            if(solve()){
                while(!sorted.isEmpty()){
                    int ans = sorted.poll();
                    System.out.print(ans + " ");
                }
                System.out.println();
            }
        }
    }


    static boolean solve(){
        boolean result = true;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i < numberOfTeam +1; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        for(int i = 1; i < numberOfTeam+1; i++){
            if(q.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                result = false;
                break;
            }
            if(q.size() > 1){
                System.out.println("?");
                result = false;
                break;
            }

            int curTeam = q.poll();
            sorted.add(curTeam);

            for(int idx = 1; idx < numberOfTeam +1; idx++) {
                if (teams[curTeam][idx] == 1) {
                    indegree[idx]--;
                    if (indegree[idx] == 0)
                        q.add(idx);
                }
            }
        }
        return result;
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
