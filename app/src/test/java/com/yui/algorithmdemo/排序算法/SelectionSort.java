package com.yui.algorithmdemo.排序算法;

import org.junit.Test;

/**
 * 选择排序
 *      时间复杂度：最好 O(n^2) 最坏 O(n^2) 平均 O(n^2)
 *      控件复杂度： O(1)
 *      In-place √
 *      稳定性 √
 * */
public class SelectionSort extends Sort{
    @Test
    public void SelectionSort(){

    }

    @Override
    protected void sort() {
        for(int end = array.length - 1;end > 0;end--){
            int maxIndex = 0;
            for(int begin = 1;begin <= end;begin++){
//                if(array[begin]>=array[maxIndex]){//这样就保证了稳定，相同大小元素前后位置不变
//                    maxIndex = begin;
//                }
                if(cmp(maxIndex,begin)<=0){//这样就保证了稳定，相同大小元素前后位置不变
                    maxIndex = begin;
                }
            }
            if(maxIndex!=end) {//防止是同一个
                swap(maxIndex,end);
//                array[maxIndex] = array[end] + array[maxIndex];
//                array[end] = array[maxIndex] - array[end];
//                array[maxIndex] = array[maxIndex] - array[end];
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
