package boj_2839;/**/

import java.util.*;
import java.io.*;

public class Main{
	
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		String[] s = in.readLine().split(" ");	
		int suger = Integer.parseInt(s[0]);

		
		int three = 0 ;
		int five = suger / 5;
		suger = suger % 5;

		while(five >= 0){
			if(suger % 3 == 0){
				three = suger / 3;
				suger = suger % 3;
				break;	
			}
			five -= 1;
			suger += 5;
			
		}
		if(suger != 0)
			System.out.print("-1");
		else
			System.out.print(five + three);

	}

}
