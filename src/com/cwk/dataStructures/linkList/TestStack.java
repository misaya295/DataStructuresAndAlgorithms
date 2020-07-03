package com.cwk.dataStructures.linkList;


import java.util.Stack;

/**
演示Stack的基本使用
 */
public class TestStack {


    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("tom");
        stack.add("dd");



        //取出
        while (stack.size() > 0) {


            //pop就是将栈顶的数据取出
            System.out.println(stack.pop());

        }
    }




}
