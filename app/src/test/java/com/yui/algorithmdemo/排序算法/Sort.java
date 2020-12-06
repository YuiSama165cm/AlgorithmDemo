package com.yui.algorithmdemo.排序算法;

public abstract class Sort {
    protected Integer[] array;
    private int cmpCount;//用来看算法调用了多少次
    private int swapCount;//用来看交换的次数
    protected void sort(Integer[] array){
        if (array == null || array.length < 2) return;

        this.array = array;

        sort();
    }
    protected abstract void sort();

    /**
     * 封装比较大小：根据索引
     * 返回值等于0，代表array[i1] == array[i2]
     * 返回值小于0，代表array[i1] < array[i2]
     * 返回值大于0，代表array[i1] > array[i2]
     **/
    protected int cmp(int i1,int i2){
        cmpCount++;
        return array[i1] - array[i2];
    }

    /**
     * 封装比较大小：根据大小
     * 返回值等于0，代表array[i1] == array[i2]
     * 返回值小于0，代表array[i1] < array[i2]
     * 返回值大于0，代表array[i1] > array[i2]
     **/
    protected int cmpElements(Integer i1,Integer i2){
        cmpCount++;
        return i1 - i2;
    }

    /**
     * 封装交换
     * */
    protected void swap(int i1,int i2){
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
