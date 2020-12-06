package com.yui.algorithmdemo.堆;

import java.util.Comparator;

/**
 * 二叉堆(最大堆)：
 *      二叉堆的逻辑结构就是一颗完全二叉树，所以也叫完全二叉堆
 *      鉴于完全二叉树的一些特性，二叉堆的底层（物理结构）一般用数组实现即可
 *
 *      索引i的规律（n是元素数量）
 *          如果i=0，它是根节点
 *          如果i>0，它的父节点的索引为floor((i-1)/2)
 *
 *          如果2i+1<=n-1，他的左子节点的索引为2i+1
 *          如果2i+1>n-1，他无左子节点
 *
 *          如果2i+2<=n-1，它的右子节点的索引为2i+2
 *          如果2i+2>n-1，它无右子节点
 *
 * */
public class BinaryHeap<E> extends AbstractHeap<E> implements Heap<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 批量建堆
     * */
    public BinaryHeap(E[] elements, Comparator<E> comparator){
        super(comparator);

        if(elements == null || elements.length == 0){
            this.elements = (E[])new Object[DEFAULT_CAPACITY];
        }else{
            size = elements.length;
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);//容量取大的值，最少10；也可以直接length，只是这样好点
            this.elements = (E[])new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }

    }

    /**
     * 批量建堆
     * */
    private void heapify() {
//        //自上而下的上滤(O(nlogn))
//        for(int i=1;i<size;i++){
//            siftUp(i);
//        }

        //自下而上的下滤(O(n))
        for (int i = (size >> 1)-1; i >=0 ; i--) {
            siftDown(i);
        }
    }

    /**
     * 批量建堆
     * */
    public BinaryHeap(E[] elements){
        this(elements,null);
    }

    public BinaryHeap(Comparator<E> comparator){
        this(null,comparator);
    }

    public BinaryHeap(){
        this(null,null);
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 添加（最大堆）：
     *      新加的元素，要跟其父节点比较大小，如果大于其父节点则交换位置，一直到不大于为止
     *      这个过程，叫做上滤（Sift Up）
     *      时间复杂度：O（log n）
     * */
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        //上滤
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();//判断是否为空
        return elements[0];
    }

    /**删除堆顶元素：下滤（Sift Down），时间复杂度：O（logn）
     *      将最后一个元素赋值到根节点（堆顶），然后把最后一个元素删除
     *      然后循环操作根节点与子节点的比较操作，一直到根节点大于所有子节点（或没有子节点）为止
     * */
    @Override
    public E remove() {
        emptyCheck();//判断是否为空

        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return root;
    }
    /**
     * 下滤（Sift Down）
     * */
    private void siftDown(int index){
        E element = elements[index];
        int half = size >> 1;//第一个叶子节点的索引 == 非叶子节点的数量
        //index < 第一个叶子节点的索引
        //必须保证index位置是非叶子节点
        while (index < half){
            //index的节点由两种情况
            //1、只有左子节点
            //2、同时有左右子节点

            //默认为左子节点跟它进行比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            //右子节点
            int rightIndex = childIndex + 1;
            //选出左右子节点大的那个
            if(rightIndex < size&&compare(elements[rightIndex],child)>0){
                childIndex = rightIndex;
                child = elements[rightIndex];
            }

            if(compare(element,child) >= 0)
                break;

            //将子节点存放到index位置
            elements[index] = child;
            //重新设置index
            index = childIndex;

        }
    }
    //删除堆顶元素的同时插入一个新元素
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;
        if(size == 0){//判断是否为空,为空则直接添加
            elements[0] = element;
            size++;
        }else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 让index元素的位置上滤
     * */
    private void siftUp(int index){
        E element = elements[index];
        while (index > 0){
            int parentIndex = (index - 1)>>1;//向右移动一位，得到父节点
            E parent = elements[parentIndex];
            if(compare(element,parent) <= 0){//小于父节点
                break;
            }
//            //交换index、parentIndex位置的内容
//            E tmp = elements[index];
//            elements[index] = elements[parentIndex];
//            elements[parentIndex] = tmp;
            //优化后代码，把父节点元素放到index位置
            elements[index] = elements[parentIndex];
            //重新赋值index
            index = parentIndex;
        }
        //优化后，所有位置调整好后，将值放入到最后确定的位置里面
        elements[index] = element;
    }


    //扩容
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity) return;

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    //数组为空判断
    private void emptyCheck(){
        if (size == 0){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    //元素为空判断
    private void elementNotNullCheck(E element){
        if (element == null){
            throw new IllegalArgumentException("element nust not be null");
        }
    }

    public Object root(){
        return 0;
    }

    public Object left(Object node){
        int index = ((int)node<<1) + 1;
        return index >= size ? null : index;
    }
    public Object right(Object node){
        Integer index = ((Integer)node<<1) + 2;
        return index >= size ? null : index;
    }

    public Object string(Object node){
        return elements[(int)node];
    }
}
