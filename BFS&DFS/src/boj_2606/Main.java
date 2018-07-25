package boj_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static node[] Nodes;
    static int num;
    static int connection;
    static int zombies = 0;

    public static void main(String[] args){
        sc.init();
        num = sc.nextInt();
        connection = sc.nextInt();

        Nodes = new node[num+1];

        for(int i = 1; i < num + 1 ; i++){
            Nodes[i] = new node(false);
        }

        for(int i = 1; i < connection +1 ; i++){
            int one = sc.nextInt();
            int two = sc.nextInt();
            Nodes[one].connected(Nodes[two]);
            Nodes[two].connected(Nodes[one]);
        }

        BFS();

        for(int i =2; i < num +1 ; i++){
            if(Nodes[i].zombie == true)
                zombies++;
        }

        System.out.println(zombies);

    }

    static void BFS(){
        Nodes[1].zombie = true;
        Nodes[1].visit = true;
        Queue<node> q = new LinkedList<node>();
        q.add(Nodes[1]);
     /*   int k = 1;
        while (!q.isEmpty()) {
            node cur = q.poll();
            if (cur != null) {
                while (!cur.connect.isEmpty()) {
                    cur.connect.poll();
                    System.out.println(k);
                    k++;
                }
            }
        }*/

        while(!q.isEmpty()){
            node curNode = q.poll();
            if(curNode != null){
                Queue<node> curConnection = curNode.getConnection();
                while(!curConnection.isEmpty()){
                node nextNode = curConnection.poll();
                if(!nextNode.visit){
                    if(curNode.zombie == true){
                        nextNode.setZombie(true);
                        nextNode.visit = true;
                        q.add(nextNode);
                    }
                }
                }
            }

        }
    }

    static class node{
        Queue<node> connect;
        public boolean zombie;
        public boolean visit;

        public node(boolean zombie) {
            this.zombie = zombie;
            this.visit = false;
            connect = new LinkedList<node>();
        }

        public void connected(node connect){
            this.connect.add(connect);
        }

        public Queue getConnection(){
            return this.connect;
        }

        public void setZombie(boolean zombie){
            this.zombie = zombie;
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }

        static String readLineReplace() {
            try {
                return br.readLine().replaceAll("\\s+", "");
            } catch (IOException e) {
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static boolean hasNext() {
            return st.hasMoreTokens();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
