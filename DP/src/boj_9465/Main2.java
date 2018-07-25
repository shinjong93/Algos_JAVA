package boj_9465;

import java.util.*;
import java.io.*;

public class Main2{

	static int[][] s = new int[2][100001];
	static int[][] dp = new int[2][100001];

	public static void main(String[] args) throws Exception{

	int n,test_value;

	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	test_value = Integer.parseInt(input.readLine());

	for(int i = 0; i < test_value; i++){
		int last = Integer.parseInt(input.readLine());
		int result = 0;
		String[] firstN = input.readLine().split(" ");
		String[] secondN = input.readLine().split(" ");
	
		for(int j = 1; j <= last; j++){
			s[0][j] = Integer.parseInt(firstN[j-1]);
			s[1][j] = Integer.parseInt(secondN[j-1]);
		}

		for(int j = 1; j <= last; j++){
			dp[0][j] = Math.max(getDP(1,j-1), getDP(1,j-2)) + s[0][j];
			dp[1][j] = Math.max(getDP(0,j-1), getDP(0,j-2)) + s[1][j];
		}  

		System.out.println(Math.max(getDP(1,last),getDP(0,last)));
	
	}
	}
	static int getDP(int x, int y){
		if(x < 0 || y < 0)
			return 0;
		return dp[x][y];
	}


}	
