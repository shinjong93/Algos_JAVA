package boj_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int Case = Integer.parseInt(s);
        Tree tree = new Tree();
        while (Case-- > 0) {
            char[] datas = br.readLine().replaceAll(" ", "").toCharArray();
            tree.add(datas[0],datas[1],datas[2]);
        }
        tree.inOrder(tree.Root);
        System.out.println();
        tree.preOrder(tree.Root);
        System.out.println();
        tree.postOrder(tree.Root);
    }

    static class Node{
        public char Data;
        public Node left;
        public Node right;

        public Node(char Data){
            this.Data = Data;
        }

    }
    static class Tree{
        Node Root;

        public void add(char data, char leftData, char rightData){
            if(Root == null){
                if(data !=  '.')
                    Root = new Node(data);
                if(leftData != '.')
                    Root.left = new Node(leftData);
                if(rightData != '.')
                    Root.right = new Node(rightData);
            } else {
                search(Root, data, leftData, rightData);
            }
        }


        public void search(Node root, char Data, char leftData, char rightData){
            if(root == null)
                return;
            else if(root.Data == Data){
                if(leftData != '.')
                    root.left = new Node(leftData);
                if(rightData != '.')
                    root.right = new Node(rightData);
            } else {
                search(root.left, Data, leftData, rightData);
                search(root.right, Data, leftData, rightData);
            }
        }
        public void inOrder(Node root){
            System.out.print(root.Data);
            if(root.left != null)
                inOrder(root.left);
            if(root.right != null)
                inOrder(root.right);
        }
        public void preOrder(Node root){
            if(root.left != null)
                preOrder(root.left);
            System.out.print(root.Data);
            if(root.right != null)
                preOrder(root.right);
        }
        public void postOrder(Node root){
            if(root.left != null)
                postOrder(root.left);
            if(root.right != null)
                postOrder(root.right);
            System.out.print(root.Data);
        }

    }
}
