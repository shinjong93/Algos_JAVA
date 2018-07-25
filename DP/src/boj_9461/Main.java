package boj_9461;import java.util.*;
import java.io.*;

public class Main {

        static long[] DP = new long[101];

        public static void main(String[] args) throws Exception{
                int n;
                int k;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                k = Integer.parseInt(input.readLine());
                DP[0] = 0;
                DP[1] = 1;
                DP[2] = 1;
		DP[3] = 1;
		DP[4] = 2;
		DP[5] = 2;

                for(int i = 6; i<= 100; i++){
			DP[i] = DP[i-1] + DP[i-5];
                }
		for(int i = 0; i < k; i++){
               		n = Integer.parseInt(input.readLine());
			System.out.println(DP[n]);
		}
        }

}


