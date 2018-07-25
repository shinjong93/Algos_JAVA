package boj_10844;

import java.util.*;
import java.io.*;

public class Main {

	static int[][] s = new int[101][10];
	static final int mod = 1000000000;

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());

		for(int i = 1; i<=9; i++){
			s[1][i] = 1;
		}
		for(int i = 2; i<=n;i++){
			for(int k = 0; k <= 9; k++){
				s[i][k] = 0;

				if(k -1 >= 0)
					s[i][k] += s[i-1][k-1];
				if(k + 1 <= 9)
					s[i][k] += s[i-1][k+1];
			
				s[i][k] = s[i][k] % mod;
			}
			
		}

		for(int i = 0; i <= 9; i++){
			result += s[n][i];
			result %=  mod;
		}

		System.out.println(result);
	}

}
