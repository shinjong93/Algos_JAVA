package boj_2193;

import java.util.*;
import java.io.*;

public class Main {

	static long [][] s = new long[91][2];
	static final int mod = 10007;

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());

		s[1][0] = 0;
		s[1][1] = 1;
		s[2][0] = 1;
		s[2][1] = 0;

		for(int i = 3; i <= n; i++){
			s[i][0] = s[i-1][0] + s[i-1][1];
			s[i][1] = s[i-1][0];
		}

		result = s[n][0] + s[n][1];

		System.out.println(result);
	}

}

