package com.cwk.dataStructures.recursion;

public class Queen8 {


    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组arr ，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] arr = new int[max];

     static int   count = 0;

    public static void main(String[] args) {


        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);



    }


    private void check(int n) {

        if (n == max) {
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n 放到该行的第一列
            arr[n] = i;
            //判断当放置第n哥皇后到i列时，是否冲突
            if (jude(n)) {
                //接着放n+1个皇后，即开始递归
                check(n+1);

            }

            //如果冲突就继续执行arr[n] =i

        }

    }


    //查看当我们放置第n个皇后，就去检测皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean jude(int n) {

        for (int i =0;i < n;i++){

            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }

        }
        return true;
    }




    //写一个方法。可以将皇后摆放的位置输出
    private void print(){
        count++;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

        }

        System.out.println();


    }
}
