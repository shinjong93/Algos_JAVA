package boj_11053;

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
				dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(number[i] > number[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j] + 1;
			}
			
		}
		for(int i = 1; i <= n; i++){
			result = Math.max(result,dp[i]);
		}
		System.out.println(result);
	}

	static int LIS(int index){
			int result = 1;
			int current = number[index];
			int before = number[index];
			System.out.printf("current index is = %d\n ",index);
			System.out.println(current);
			for(int i = index; i <= n; i++){
				if(current < number[i]){
					result++;
					before = current;
					current = number[i];
					System.out.println(current);
				} 
				else if(current > number[i] && before < number[i]){
					current = number[i];
					System.out.println("current changed");
					System.out.println(current);
				}
			}

			System.out.println();
			return result;	
		}
	}
