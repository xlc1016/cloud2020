package com.xlc.springcloud;


/**
* @author :xlc
* @date: 2020-4-26
* @description: 获取类加载器
*/
public class Test01 {

    public static void main(String[] args){
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader); // 系统类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent); // 扩展类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); // 根类 java 无法获取 用c++编写

    }
}
