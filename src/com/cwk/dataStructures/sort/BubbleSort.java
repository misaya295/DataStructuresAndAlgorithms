package com.cwk.dataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {


    public static void main(String[] args) {
        int arr[] = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date date1 = new Date();

        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

        String date1Str = SimpleDateFormat.format(date1);
        System.out.println(date1Str);

        bulleSort(arr);
        Date date2 = new Date();


        String date2Str = SimpleDateFormat.format(date2);
        System.out.println(date2Str);


    }


    private  static int[] bulleSort(int[] arr) {

        //冒泡排序演变过程
        int tmp = 0;//临时变量
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {


            //第一趟排序，就是将最大的数排在最后

            for (int j = 0; j < arr.length - 1 -i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                }

            }

//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return arr;
    }
}



