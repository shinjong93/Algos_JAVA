package boj_2156;

import java.util.*;
import java.io.*;

public class Main{
	static int[] dp = new int[10001];
	static int[] cost = new int[10001];

	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(input.readLine());

		for(int i = 0; i < n; i++){
			cost[i+1] = Integer.parseInt(input.readLine());
		}

		dp[1] = cost[1];
		dp[2] = dp[1] + cost[2];

		for(int i = 1; i <= n; i++){
			dp[i] = Math.max(getDP(i-2)+cost[i] , getDP(i-3) + cost[i-1] + cost[i]);
			dp[i] = Math.max(getDP(i-1),getDP(i));
		}
		System.out.println(getDP(n));

		
	}

	static int getDP(int x){
		if( x < 0)
			return 0;
		return dp[x];
	}
}
