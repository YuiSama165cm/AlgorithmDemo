package com.yui.algorithmdemo.utils;

import java.text.SimpleDateFormat;

public class Times {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SS");

    public interface Task{
        void execute();
    }

    public static void test(String title, Task task){
        if( task == null) return;
//        title = (title == null) ? "" : ("["+tltle +)
    }
}
