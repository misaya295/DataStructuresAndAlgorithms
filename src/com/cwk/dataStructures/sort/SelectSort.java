package com.cwk.dataStructures.sort;



import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {
        int arr[] = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date date1 = new Date();

        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

        String date1Str = SimpleDateFormat.format(date1);
        System.out.println(date1Str);

        selectSott(arr);
        Date date2 = new Date();


        String date2Str = SimpleDateFormat.format(date2);
        System.out.println(date2Str);


    }


    private static int[]  selectSott(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {


            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                if (min > arr[j]) {//说明假定的最小值，不是最小

                    min = arr[j];//重制min

                    minIndex = j;//重置minindex
                }


            }

            //将最小值，放在arr[0] ,交换
            arr[minIndex] = arr[i];
            arr[i] = min;

//            System.out.println("第"+i+"轮后");
//            System.out.println(Arrays.toString(arr));

        }

        return arr;

    }

}
