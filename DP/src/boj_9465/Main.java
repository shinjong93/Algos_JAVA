package boj_9465;

import java.util.*;
import java.io.*;

public class Main{

	static int[][] s = new int[2][100001];

	public static void main(String[] args) throws Exception{

	int n,test_value;

	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	test_value = Integer.parseInt(input.readLine());

	for(int i = 0; i < test_value; i++){
		int total = Integer.parseInt(input.readLine());
		int result = 0;

		String[] firstN = input.readLine().split(" ");
		String[] secondN = input.readLine().split(" ");
	
		for(int j = 1; j <= total; j++){
			s[0][j] = Integer.parseInt(firstN[j-1]);
			s[1][j] = Integer.parseInt(secondN[j-1]);
		}
		for(int k = 1; k <= total; k++)	{	
			int tmp1 = 0;
			int tmp2 = 0;
			if(k == 1){
				if(s[0][1] + s[0][2] > s[1][1] + s[1][2]){
					result += s[1][1];
					change(1,1);
				}
				else if(s[0][1] + s[0][2] < s[1][1] + s[1][2]){
					result += s[0][1];
					change(0,1);		 
				}
				else if(s[0][1] + s[0][2] == s[1][1] + s[1][2]){
					if(s[0][1] >= s[1][1]){
						result += s[0][1];
						change(0,1);
					}
					else{
						result += s[1][1];
						change(1,1);
					}
				}
			}
			else{
				if(s[0][k] + s[1][k+1] > s[0][k+1] + s[1][k]){
					result += s[0][k];
					change(0,k);
				}
				else{
					result += s[1][k];
					change(1,k);
				}
			}
		}
			System.out.println(result);
		}

	}

	public static void change(int row, int col){
		if(col == 1){
			if(row == 0){
				s[row + 1][col] = 0;
				s[row][col+1] = 0;
			}
			else{
				s[row-1][col] = 0;
				s[row][col+1] = 0;
			}	
		}
		else{
			if(row == 0)
				s[row+1][col] = 0;
			else
				s[row-1][col] = 0;

			s[row][col+1] = 0;
			s[row][col-1] = 0;
		}
	}

}
