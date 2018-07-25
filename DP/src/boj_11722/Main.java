package boj_11722;

import java.util.*;
import java.io.*;

public class Main{
	static int[] up = new int[1001];
	static int[] down = new int[1001];
	static int[] number = new int[1001];
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		int result = 1;
		int before = 0;
		int current = 0;
		String[] s = input.readLine().split(" ");

		for(int i = 0; i < n; i++){
			number[i+1] = Integer.parseInt(s[i]);
		}

		
		for(int i = 1; i <= n; i++){
			if(n == 1) {
				break;
			}
				up[i] = 1;
				down[i] = 0;
				before = number[i];
				current = number[i];
				
			for(int j = 1; j <= n; j++){
					if(number[i] > number[j] && up[i] < up[j]+1 && i >= j)
						up[i] = up[j] + 1;
					else if(i<j) {
						if(number[j] > current && number[j] < before) {
							current = number[j];
						}
						else if(number[j] < current && number[j] < before) {
							before = current;
							current = number[j];
							down[i] += 1;
						}
						else if(number[i] > number[j] && before < number[j] && current < number[j]) {
							
						}
					}
						
			}
			
		}
		for(int i = 1; i <= n; i++){
			//result = Math.max(result,up[i] + down[i]);
			System.out.println("Each Case  " + i);
			System.out.println(up[i]);
			System.out.println("//////////////////////");
			System.out.println(down[i] + "\n"); 
			
		}
		System.out.println(result);
	}
}