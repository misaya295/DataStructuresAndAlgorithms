package com.cwk.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {


    public static void main(String[] args) {
        int arr[] = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date date1 = new Date();

        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

        String date1Str = SimpleDateFormat.format(date1);
        System.out.println(date1Str);

        insertSort(arr);
        Date date2 = new Date();


        String date2Str = SimpleDateFormat.format(date2);
        System.out.println(date2Str);

    }


    //插入排序

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            //使用逐步推导方式来讲解，便利理解

            //第一轮{101,34,119,1} => {34,101,119,1}


            //定义待插入的数
            int insertval = arr[i];
            int insertIndex = i - 1;  //即arr[1]的前面这个数的下标


            //给insertVal 找到插入的位置
            //说明
            //1. insertIndex >= 0 保证在给insertval 找插入位置，不越界
            //2. insertVal < arr[insertIndex]  待插入的数，还没有找到插入的位置
            //3. 就需要将arr[insertIndex] 后移
            while (insertIndex >= 0 && insertval < arr[insertIndex]) {

                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当推出while循环时，说明插入的位置找到，insertIndex + 1
            arr[insertIndex + 1] = insertval;
//            System.out.println("第"+i+"轮输入");
//            System.out.println(Arrays.toString(arr));

        }




    }
}
