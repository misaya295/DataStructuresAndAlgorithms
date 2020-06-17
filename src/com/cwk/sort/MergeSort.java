package com.cwk.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);



    }


    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }


    /**
     *合并的方法
     * @param arr  排序的原始数组
     * @param left 左边有序序列的初始化索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp 做中转数据
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//temp数组索引



        //1.先把左右两边数据按规则填充到temp，直到左右两边有一边处理完毕
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {

                temp[t] = arr[i];
                t += 1;
                i += 1;


            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }


        //2.把有剩余数据的一遍的数据依次全部填充到temp
        while (i <= mid) {

            temp[t] = arr[i];
            t += 1;
            i += 1;

        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }



        //3.将temp数组元素拷贝到arr
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }










    }


}
