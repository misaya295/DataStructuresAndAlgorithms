package com.cwk.dataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {


    public static void main(String[] args) {

        int arr[] = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date date1 = new Date();

        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

        String date1Str = SimpleDateFormat.format(date1);
        System.out.println(date1Str);

        shellSort2(arr);
        Date date2 = new Date();


        String date2Str = SimpleDateFormat.format(date2);
        System.out.println(date2Str);




    }


    //使用逐步推倒的方式编写希尔排序
    private static void shellSort(int[] arr) {
        int tmp = 0;
        int count = 0;
        for (int k = arr.length / 2; k > 0; k /= 2) {

            //希尔排序第一轮
            //因为第一轮排序，是将10个数据分成了5组
            for (int i = k; i < arr.length; i++) {
                //遍历各组中所有的元素（共五组，每组有两个）

                for (int j = i - k; j >= 0; j -= k) {
                    if (arr[j] > arr[j + k]) {

                        tmp = arr[j];
                        arr[j] = arr[j + k];
                        arr[j + k] = tmp;
                    }


                }
            }
//            System.out.println("希尔排序"+(++count)+"轮以后:" + Arrays.toString(arr));

        }





    }

    //对交换式的希尔排序进行优化->移位法
    private static void shellSort2(int[] arr) {


        //增量gap，并逐步的缩小常量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素，这个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {


                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }


                    //当退出while后，就给tmp找到插入的位置
                    arr[j] = temp;
                }
            }


        }
    }




}
