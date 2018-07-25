package boj_14503;import java.util.*;
import java.io.*;

public class Main{
	public static int nC; // 열의 갯수
	public static int nR; // 행의 갯수
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");
		nR = Integer.parseInt(s[0]);
		nC = Integer.parseInt(s[1]);
		int[][] room = new int[nC][nR];

		int rR, rC, rD;
		s = in.readLine().split(" ");
		rR = Integer.parseInt(s[0]);
		rC = Integer.parseInt(s[1]);
		rD = Integer.parseInt(s[2]);

		for(int i = 0; i < nR; i++){
			s = in.readLine().split(" ");
			for(int j = 0; j < nC; j++){
				room[i][j] = Integer.parseInt(s[j]);
			}
		}

		int result = robot(rR,rC,rD,room);	

				
	}
	public static int robot(int row, int col, int direct,int[][] room){
		return 0;
	}
}


/*
	1.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한칸을 전진하고 1번부터 진행
	2.왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	3.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	4.네 방향 모두 청소가 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

	0이면 북쪽 1이면 동쪽 2이면 남쪽 3이면 서쪽 북 -> 서 -> 남 -> 동 -> 북 방향으로 회전한다.
	북을 보고 있을 때 한칸 청소하러 가면  row -1
	남을 보고 있을 때 한칸 청소하러 가면  row +1
	서를 보고 있을 때 한칸 청소하러 가면  col -1
	동을 보고 있을 때 한칸 청소하러 가면  col +1

 
*/
