package com.cwk.dataStructures.tree;

public class ArrBinaryTreeDemo {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();


    }



}

class ArrBinaryTree {


    private int arr[]; //存储数据结点的数组


    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }


    //编写一个方法，完成顺序存储二叉树的前序遍历

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {


        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空");
        }

        System.out.println(arr[index]);
        //向左递归遍历
        if ((2 * index + 1) < arr.length) {

            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }


    }



}


