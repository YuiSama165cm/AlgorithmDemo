package com.yui.algorithmdemo.sort;

import org.junit.Test;

/**
 * 选择排序
 *      时间复杂度：最好 O(n^2) 最坏 O(n^2) 平均 O(n^2)
 *      控件复杂度： O(1)
 *      In-place √
 *      稳定性 √
 * */
public class SelectionSort {
    @Test
    public void SelectionSort(){
        Integer[] arr = {5,3,7,8,11,1,2,11};
        SelectionSort(arr);

    }

    public void SelectionSort(Integer[] array){
        for(int end = array.length - 1;end > 0;end--){
            int maxIndex = 0;
            for(int begin = 1;begin <= end;begin++){
                if(array[begin]>=array[maxIndex]){//这样就保证了稳定，相同大小元素前后位置不变
                    maxIndex = begin;
                }
            }
            if(maxIndex!=end) {//防止是同一个
                array[maxIndex] = array[end] + array[maxIndex];
                array[end] = array[maxIndex] - array[end];
                array[maxIndex] = array[maxIndex] - array[end];
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
