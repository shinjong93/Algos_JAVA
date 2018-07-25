package boj_1912;import java.util.*;
import java.io.*;

public class Main {

	static int[] DP = new int[100001];
	static int[] num = new int[100001];

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());
		String[] s = input.readLine().split(" ");

		for(int i = 0; i<n; i++){
			num[i+1] = Integer.parseInt(s[i]);
		}

		DP[1] = num[1];
		result = DP[1];

		for(int i = 2; i<=n; i++){
			DP[i] = Math.max(DP[i-1] + num[i] , num[i]);
			result = Math.max(result,DP[i]);
		}


		System.out.println(result);
	}

}

