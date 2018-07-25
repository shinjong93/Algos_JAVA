package boj_1967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Main {
    static int v,u,r;
    static ArrayList<Node>[] adjcent;
    static int[] distance;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        adjcent = (ArrayList<Node>[]) new ArrayList[100001];
        distance = new int[100001];

        for(int i = 1; i < 100001; i++){
            adjcent[i] = new ArrayList<>();
        }

        int Case = Integer.parseInt(br.readLine());
        while (Case --> 1){
            String[] s = br.readLine().split(" ");
                int parent = Integer.parseInt(s[0]);
                int child = Integer.parseInt(s[1]);
                int weight = Integer.parseInt(s[2]);
                adjcent[parent].add(new Node(child,weight));
                adjcent[child].add(new Node(parent,weight));
            }
            DFS(1,0);
            r = 0;
            distance = new int[100001];
            DFS(u,0);
            System.out.println(r);
        }


    public static void DFS(int v, int d){
        distance[v] = d;
        if(distance[v] > r){
            r = distance[v];
            u = v;
        }

        for(Node node : adjcent[v]){
            int next = node.number;
            int weight = node.weight;

            if(distance[next] == 0)
                DFS(next,d + weight);
        }
    }

    static class Node{
        int weight;
        int number;
        Node(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
    }
}
