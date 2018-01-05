package com.haoge.demo.baselib.tool;

import android.app.Activity;

import java.util.LinkedList;

/**
 * @author haoge on 2018/1/4.
 */

public class ActivityManager {

    private static LinkedList<Activity> stack = new LinkedList<>();

    /**
     * 添加一个Activity到模拟栈中。
     * @param activity 需要放入的Activity实例。
     */
    public static void add (Activity activity) {
        if (activity == null || activity.isFinishing()) return;
        if (!stack.contains(activity)) {
            stack.add(activity);
        }
    }

    /**
     * 将模拟栈中顶层的Activity移除
     */
    public static void pop () {
        if (!stack.isEmpty()) {
            Activity pop = stack.pop();
            recycler(pop);
        }
    }

    /**
     * 将指定Activity从模拟栈中移除
     * @param activity 指定移除的Activity
     */
    public static void pop (Activity activity) {
        if (stack.contains(activity)) {
            stack.remove(activity);
            recycler(activity);
        }
    }

    /**
     * 将模拟栈中所有的Activity移除清空。
     */
    public static void popAll () {
        while (!stack.isEmpty()) {
            Activity pop = stack.pop();
            recycler(pop);
        }
    }

    /**
     * 获取栈中最顶层的Activity
     * @param <T> T extends Activity
     * @return 最顶层的Activity
     */
    public static <T extends Activity> T top () {
        if (!stack.isEmpty()) {
            //noinspection unchecked
            return (T) stack.getLast();
        }
        return null;
    }

    private static void recycler (Activity activity) {
        if (activity == null || activity.isFinishing()) return;
        activity.finish();
    }
}
