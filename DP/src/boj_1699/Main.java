package boj_1699;import java.util.*;
import java.io.*;

public class Main {

	static int[] DP = new int[100001];
	static int INF = 123456789;

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());

		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 3;

		for(int i = 1; i*i <= 100000; i++)
			DP[i*i] = 1;

		for(int i = 4; i <= n; i++){
			if(DP[i] == 0)
				DP[i] = INF;
			for(int j = 1; j <= i; j++){
				DP[i] = Math.min(DP[i], DP[i-j] + DP[j]);
			}
		}

		System.out.println(DP[n]);
	}

}

