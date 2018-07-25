package boj_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] array = new int[100001];
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int Case = Integer.parseInt(s);
        Tree tree = new Tree();
        Arrays.fill(array, -1);

        while(Case --> 1){
            String[] numbers = br.readLine().split(" ");
            int data = Integer.parseInt(numbers[0]);
            int Cdata = Integer.parseInt(numbers[1]);
            tree.add(data,Cdata);
        }

        tree.Print(1);
     //   for(int i = 1; i <= Case; i++){
    //        tree.Print(i);
   //     }

     //   for(int i = 2; i < 10; i++){
          //  if(array[i] != -1)
          //      System.out.println(array[i]);
          //  else {
          //      System.out.println(array[i]);
               // break;
          //  }
      //  }

    }
    static class Node{
        public int Data;
        public Node Lchild;
        public Node Rchild;
        public Node parrent;

        public Node(int Data){
            this.Data = Data;
        }
    }

    static class Tree{
        Node root;
        public void add(int Data, int CData){
            if(root == null){
                root = new Node(Data);
                if(root.Lchild != null) {
                    root.Rchild = new Node(CData);
                    root.Rchild.parrent = root;
                } else {
                    root.Lchild = new Node(CData);
                    root.Lchild.parrent = root;
                }

            } else {
                search(root,Data, CData);
            }
        }
        public void search(Node root,int Data, int CData){
            if(root == null)
                return;
            else if(root.Data == Data){
                if(root.Lchild == null) {
                    root.Lchild = new Node(CData);
                    root.Lchild.parrent = root;
                } else {
                    root.Rchild = new Node(CData);
                    root.Rchild.parrent = root;
                }
            } else {
                search(root.Lchild, Data, CData);
                search(root.Rchild, Data, CData);
            }
        }
        public void Print(int Data){
            //printTree(root, Data);
            inOrder(this.root);
        }


        public void printTree(Node root, int Data){
            if(root == null)
                return;
            else{
                if(root.Data == Data)
                    array[Data] = root.parrent.Data;
                if(root.Lchild != null)
                    printTree(root.Lchild,Data);
                if(root.Rchild != null)
                    printTree(root.Rchild,Data);
            }
        }

        public void inOrder(Node root){
            System.out.print(root.Data);
            if(root.Lchild != null)
                inOrder(root.Lchild);
            if(root.Rchild != null)
                inOrder(root.Rchild);
        }
    }
}
