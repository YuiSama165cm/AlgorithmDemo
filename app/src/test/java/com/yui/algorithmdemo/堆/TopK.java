package com.yui.algorithmdemo.堆;

import java.util.Comparator;

/**
 * Top K问题：
 *      从n个整数中，找出最大的前k个数（k远远小于n）
 *
 * 方案：
 *      1、如果使用排序算法进行全排序，需要O（nlogn）的时间复杂度（快速排序）
 *
 *      2、如果使用二叉堆来处理，可以使用O（nlogk）的时间复杂度来解决
 *
 * 思路：用小顶堆处理
 *      1、先将遍历到的前k个数放入堆中
 *      2、从第k + 1 个数开始，如果大于堆顶元素，就使用replace操作（删除堆顶元素，将第 k + 1 个数添加到堆中）
 *
 *
 *      如果是找最小k个，则用大顶堆；如果找最大k个数，就用小顶堆
 *
 * */
public class TopK {
    public void test(){
        //通过修改Compartor，大小反向判断，完成小顶堆
        Integer[] data = {88,33,66,55,22,11,99,12,15,18,25,28,36,58,69,87};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //找出最大的前k个数
        int k=5;
        for (int i = 0; i < data.length; i++) {
            if(heap.size()<k){//前k个数添加到小顶堆
                heap.add(data[i]);//logk
            }else if(data[i]>heap.get()){//如果是第 k + 1个之后的数，则新元素与堆顶元素大小比较，大于堆顶则替换
                heap.replace(data[i]);//logk
            }
        }
    }
}
