package boj_2577;

import java.util.*;
import java.io.*;

public class Main{
	
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		String[] s;
		int[] i = new int[10];
		int a = 1;
		for(int k = 0; k < 3; k++){
			s = in.readLine().split(" ");
			a *= Integer.parseInt(s[0]);
		}

	//	System.out.println(a);


		String sTotal = String.valueOf(a);

		for(int k = 0; k < sTotal.length(); k++){
			i[sTotal.charAt(k) - 48] += 1;
		}
		for(int k = 0; k < 10; k++)
			System.out.println(i[k]);
	}
}


