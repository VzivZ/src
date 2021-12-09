package yjt;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/3/4 9:35
 */
public class Demo004<T> {
    private T obj;

    Demo004(T obj) {
        this.obj = obj;
    }

    public T getT() {
        return obj;
    }

    <E> void show(E e) {
        System.out.println(e+"☭");
    }

    <E> void showSize(E e) {
        if (e == null) return;
        System.out.println(String.valueOf(e).length());
    }

    public void test(List<? extends Number> list) {
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("java.math.BigDecimal  ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
