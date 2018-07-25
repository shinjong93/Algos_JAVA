package boj_1016;

/*제곱 ㄴㄴ 수*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static long min;
    static long max;
    static long total = 0;
    static long start;
    static long end;
    static long[] arr;
    public static void main(String[] args) throws Exception{
        sc.init();
        min = sc.nextLong();
        max = sc.nextLong();
        start = (long)Math.sqrt(min);
        end = (long)Math.sqrt(max);
        arr = new long[1000001];
        Arrays.fill(arr,-2);

        for(int i = 1; i < 1000001; i++){
            if(min + (i-1) > max)
                break;
            arr[i] = min + (i -1);
        }

        for(long i = 2; i < end; i++){
            int index = 1;
            while(index < 1000001){
                System.out.println("aaaaaaaaaaaaaaaaaa");
                if(arr[index] != -2  ){
                    if(arr[index] % (i*i) == 0){
                        arr[index] = -1;
                    }
                } else if(index >= 1000001) {
                    break;
                }
                index++;
            }
        }

        for(int k = 1; k < 100001; k++){
            System.out.println("BBBBBBBBBBBBBBBBBB");
            if(arr[k] == -2)
                break;
            if(arr[k] > -1)
                total++;
        }

        System.out.println(total);
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
