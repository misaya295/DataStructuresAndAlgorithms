package com.cwk.dataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {


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

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);



    }

    //基数排序方法
    public static void radixSort(int[] arr) {



        //根据前面的推导过程，我们可以得到最终的基数排序代码

        //1.得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        //得到最大数的位数
        int maxlength = (max + "").length();




        // 定义一个二位数组，表示10个桶，每个桶都是一个一维数组
        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length()
        //3.名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];


        //为了记录每个桶中，实际存放了多少个数据，我们定义一个数组来记录各个桶每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCount[0] ,记录就是bucket[0]桶放入数据个数
        int[] bucketElementCounts = new int[10];


        for (int i = 0,n=1; i < maxlength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {

                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;

                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;


            }
            //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一桶，并将桶中的数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第K个桶（即第K个一维数组）放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];

                    }

                    bucketElementCounts[k] = 0;
                }

            }
//            System.out.println("第" + (i + 1) + "轮后" + Arrays.toString(arr));
        }



//        //------------------------------------------------------------
//        //第二轮
//
//        for (int j = 0; j < arr.length; j++) {
//
//            //取出每个元素的个位的值
//            int digitOfElement = arr[j] /10 % 10;
//
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//
//
//        }
//        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一桶，并将桶中的数据，放入到原数组
//        for (int k = 0; k < bucketElementCounts[k]; k++) {
//            //如果桶中，有数据，我们才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环该桶即第K个桶（即第K个一维数组）放入
//                for (int l = 0; l < bucketElementCounts[k]; k++) {
//                    //取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//
//                }
//            }
//            bucketElementCounts[k] = 0;
//
//        }
//
//
//        //------------------------------------------------------------
//        //第三轮
//
//        for (int j = 0; j < arr.length; j++) {
//
//            //取出每个元素的个位的值
//            int digitOfElement = arr[j] /100 % 10;
//
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//
//
//        }
//        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一桶，并将桶中的数据，放入到原数组
//        for (int k = 0; k < bucketElementCounts[k]; k++) {
//            //如果桶中，有数据，我们才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环该桶即第K个桶（即第K个一维数组）放入
//                for (int l = 0; l < bucketElementCounts[k]; k++) {
//                    //取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//
//                }
//            }
//        }
    }

}
