package boj_1977;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

/* 완전 제곱수 구하기. */
public class Main {
    static int[] arr;
    static int start;
    static int end;
    static int MIN = 987654321;
    static int total = 0;
    public static void main(String[] args) throws Exception{
        sc.init();
        arr = new int[10001];
        Arrays.fill(arr,-1);
        for(int i = 1; i < 101; i++){
            arr[i*i] = i*i;
        }
        start = sc.nextInt();
        end = sc.nextInt();

        for(int i = start; i < end+1; i++){
            if(arr[i] != -1){
                if(MIN > arr[i])
                    MIN = arr[i];
                total += arr[i];
            }
        }

        if(MIN == 987654321)
            System.out.println(-1);
        else{
            System.out.println(total);
            System.out.println(MIN);
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
