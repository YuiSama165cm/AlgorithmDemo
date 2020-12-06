package com.yui.algorithmdemo;

import com.yui.algorithmdemo.堆.BinaryHeap;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        //通过修改Compartor，大小反向判断，完成小顶堆
//        Integer[] data = {88,33,66,55,22,11,99};
//        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        //大顶堆
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(73);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(20);

        for (int i = 0; i < heap.size(); i++) {
//            System.out.print();
        }
    }

}