package org.kmjs.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectTest {
    public long num = 123456;
    public String name = "xiaoming";

    @Override
    public String toString() {
        return "num=" + num + "/name=" + name;
    }

    public void print() {
        System.out.println(toString());
    }

    public void set(long num, String name) {
        this.num = num;
        this.name = name;
    }

    private void privateFun() {
        System.out.println("private func");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        try {
            Class reClass = ReflectTest.class;  // 反射获取class的第一种方法
            Class reClass2 = Class.forName("org.kmjs.java.ReflectTest"); // 反射获取class的第二种方法

            if(reClass == reClass2) {
                System.out.println("class is single");
            }

            Field[] fields = reClass.getFields();
            System.out.println("fields: " + Arrays.asList(fields));

            Method[] methods = reClass.getMethods();
            System.out.println("methods: " + Arrays.asList(methods));

            Constructor[] constructors = reClass.getConstructors();
            System.out.println("constructors: " + Arrays.asList(constructors));

            Object reObject = reClass.newInstance();
            Method method = reClass.getMethod("print");
            method.invoke(reObject, null);

            // getMethods是获取类中所有公共方法，包括继承自父类的
            Method method1 = reClass.getMethod("set", long.class, String.class);
            method1.invoke(reObject, 123789, "daming");
            method.invoke(reObject, null);

            // getDeclaredMethod获取声明的任何权限的方法，包括私有方法
            Method method2 = reClass.getDeclaredMethod("privateFun");
            method2.setAccessible(true);
            method2.invoke(reObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
