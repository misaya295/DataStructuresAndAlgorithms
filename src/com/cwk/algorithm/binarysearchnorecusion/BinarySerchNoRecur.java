package com.cwk.algorithm.binarysearchnorecusion;

public class BinarySerchNoRecur {


    public static void main(String[] args) {

        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 8);
        System.out.println(index);


    }


    //二分查找非递归

    /**
     *
     * @param arr 带查找的数组
     * @param target 需要查找的数
     * @return  返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {

                //需要向左边查找
                right = mid - 1;
            } else {

                //向右边查找
                left = mid + 1;
            }

        }
        return -1;


    }



}
