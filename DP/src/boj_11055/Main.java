package boj_11055;

import java.util.*;
import java.io.*;


public class Main{
	static int[] dp = new int[1001];
	static int[] number = new int[1001];
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		int current;
		int result = 1;
		String[] s = input.readLine().split(" ");

		for(int i = 0; i < n; i++){
			number[i+1] = Integer.parseInt(s[i]);
		}

		for(int i = 1; i <= n; i++){
				dp[i] = number[i];
			for(int j = 0; j < i; j++){
				if(number[i] > number[j] && dp[i] < dp[j]+number[i])
					dp[i] = dp[j] + number[i];
			}
			
		}
		for(int i = 1; i <= n; i++){
			result = Math.max(result,dp[i]);
		}
		System.out.println(result);
	}
	}