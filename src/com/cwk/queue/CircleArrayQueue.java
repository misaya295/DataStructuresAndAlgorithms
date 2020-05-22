package com.cwk.queue;

import java.awt.*;
import java.util.Scanner;

public class CircleArrayQueue {

    public static void main(String[] args) {
        //创建一个队列
        CirclArray arrayQueue = new CirclArray(3);
        /*
        接受用户的输入
         */
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {

            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");

            System.out.println("h(head)：查看队列头的数据");

            /*接受一个一数据*/
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);

                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                /*
                查看队列头的数据
                 */
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    /*
                    退出
                     */
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
    }

}


class CirclArray {
    /**
     /表示数组的最大容量
     */
    private int maxSize;

    /**
     font的变量的含义做一个调整：font就指向队列的第一个元素，也就是说arr[font]就是队列的第一个元素，font的初始值=0
     */
    private int front;
    /**
     rear的变量含义做一个调整，rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做为约定，rear的初始值=0
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public CirclArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     *
     判断队列是否是满的
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    /**
     * 判断队列是否为空
     */

    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        /*
        判断队列是否为空
         */
        if (isFull()) {
            System.out.println("队列满，不能加入数据～");
            return;
        }

        /*
         * 直接将数据加入，将rear后移，这里必须考虑取模
         */

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        /*
        判断队列是否为空
         */
        if (isEmpty()) {
            /*
            通过抛出异常
             */

            throw new RuntimeException("队列空,不能取数据");
        }

        /*
        这里需要分析出front是指向队列的第一个元素
        1.先把front对应的值保留到一个临时变量
        2.将front后移，考虑取模
        3.将临时保存的变量返回
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }



    /**
     * 显示队列的所有数据
     *
     **/
    public void  showQueue() {


        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        /*
        思路：从front开始遍历，遍历多少个元素

         */
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]\n", i % maxSize, arr[i % maxSize]);
        }


    }

    /**
    求出当前队列有效数据的个数
     */
    public int size() {


        return (rear + maxSize - front) % maxSize;


    }
    /**
     * 显示队列的头数据，注意不是取出数据
     */

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");

        }

        return arr[front];

    }


}