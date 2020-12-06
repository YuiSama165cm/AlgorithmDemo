package com.yui.algorithmdemo.sort;

import org.junit.Test;

/**
 * 冒泡排序
 *      时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
 *      控件复杂度： O(1)
 *      In-place √
 *      稳定性 √
 * */
public class BubbleSort {
    /**
     * 从头开始，比较相邻的两个数据，
     * */
    @Test
    public void BubbleSort(){
        BubbleSortProPro();
    }

    //基本的冒泡排序
    public void BubbleSortBase(){
        int[] array = {35,10,9,26,33,12,5,8,1};
        for(int end = array.length;end > 1;end--) {
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    array[begin] = array[begin] + array[begin - 1];
                    array[begin - 1] = array[begin] - array[begin - 1];
                    array[begin] = array[begin] - array[begin - 1];
                }
            }
        }
        System.out.print("得到的数组是：");
        for (int begin:array) {
            System.out.print("" + begin+" ");
        }
    }
    //判断是否已经有序
    public void BubbleSortPro(){
        int[] array = {35,10,9,26,33,12,5,8,1};
        for(int end = array.length;end > 1;end--) {
            boolean flag = true;//用来判断是否已经有序
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    flag = false;
                    array[begin] = array[begin] + array[begin - 1];
                    array[begin - 1] = array[begin] - array[begin - 1];
                    array[begin] = array[begin] - array[begin - 1];
                }
            }
            if(flag){
                break;
            }
        }
        System.out.print("得到的数组是：");
        for (int begin:array) {
            System.out.print("" + begin+" ");
        }
    }

    //如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数
    public void BubbleSortProPro(){
        int[] array = {35,10,9,26,33,12,5,8,1,50,66,77,88,99};
        for(int end = array.length;end > 1;end--) {
            int newEnd = 0;//这初始值，为完全有序的情况下做准备
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    newEnd = begin;
                    array[begin] = array[begin] + array[begin - 1];
                    array[begin - 1] = array[begin] - array[begin - 1];
                    array[begin] = array[begin] - array[begin - 1];
                }
            }
            end = newEnd+1;
        }
        System.out.print("得到的数组是：");
        for (int begin:array) {
            System.out.print("" + begin+" ");
        }
    }

}
