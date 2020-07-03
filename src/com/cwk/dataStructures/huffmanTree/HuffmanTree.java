package com.cwk.dataStructures.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {

        int arr[] = {13, 7, 8, 3, 29, 6, 1};

        Node root = createHuffmanTree(arr);


        preOrder(root);

    }


    public static void preOrder(Node root) {
        if (root != null) {
            root.preorder();

        } else {
            System.out.println("空树");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //遍历arr
        //将arr每个元素构建成一个node
        //将Node放入ArrayList
        List<Node> nodes = new ArrayList<Node>();


        for (int value : arr) {
            nodes.add(new Node(value));
        }


        while (nodes.size() > 1) {


        //排序从小到大
        Collections.sort(nodes);


        System.out.println("node=" + nodes);

        //取出根结点权值最小的的两颗二叉树
        //取出权值最小的结点
        Node left = nodes.get(0);
        //取出权值第二小的结点
        Node right = nodes.get(1);

        //构建一颗新的二叉树
        Node parent = new Node(left.value + right.value);
        parent.left = left;
        parent.right = right;


        //从ArrayList删除
        nodes.remove(right);
        nodes.remove(left);
        nodes.add(parent);



        }
        return nodes.get(0);


    }



}


class Node implements Comparable<Node> {



    int value;  //结点权值

    Node left;  //指向左子结点

    Node right; //指向右子结点


    public void preorder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preorder();

        }
        if (this.right != null) {
            this.right.preorder();

        }
    }


    public Node(int value) {

        this.value = value;
    }



    @Override
    public int compareTo(Node o) {
        //从小到大排
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
