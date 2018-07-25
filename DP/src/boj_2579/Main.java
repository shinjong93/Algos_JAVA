package boj_2579;import java.util.*;
import java.io.*;

public class Main {

	static int[] DP = new int[301];
	static int[] num = new int[301];

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());

		for(int i = 0; i<n; i++){
			num[i+1] = Integer.parseInt(input.readLine());
		}

		DP[1] = num[1];
		DP[2] = Math.max(DP[1],0) + num[2];
		DP[3] = Math.max(DP[1],num[2]) + num[3];

		for(int i = 4; i<=n; i++){
			DP[i] = Math.max(DP[i-3] + num[i-1] + num[i], DP[i-2] + num[i]);
		}



		System.out.println(DP[n]);
	}

}

