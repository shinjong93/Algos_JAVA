package boj_11057;

import java.util.*;
import java.io.*;

public class Main {

	static int[][] s = new int[1001][10];
	static final int mod = 10007;

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());

		for(int i = 0; i<=9; i++){
			s[1][i] = 1;
		}
		for(int i = 2; i<=n;i++){
			for(int j = 0; j <= 9; j++){
				for(int k = 9; k >= j; k--){
					s[i][j] += s[i-1][k] % mod;
				}
			}
			
		}

		for(int i = 0; i <= 9; i++){
			result += s[n][i] % mod;
			result %= mod;
		}

		System.out.println(result);
	}

}

