package boj_2133;import java.util.*;
import java.io.*;

public class Main {

	static int[] DP = new int[31];

	public static void main(String[] args) throws Exception{
		int n;
		long result = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(input.readLine());
		DP[0] = 1;
		DP[1] = 0;
		DP[2] = 3;

		for(int i = 3; i<= n; i++){
			if(i%2 == 1)
				DP[i] = 0;
			if(i%2 == 0){
				DP[i] = DP[i-2] * 3;
				for(int j = 2; i-2*j >=0; j++)
					DP[i] += DP[i-2*j]*2;
			}
		}

		System.out.println(DP[n]);
	}

}

