package com.xlc.springcloud;


/**
* @author :xlc
* @date: 2020-4-26
* @description:  类的执行过程
*/
public class Test {
    public static void main(String[] args){
            A a = new A();
        System.out.println(a.m);
    }
}
class A{

    static {
        System.out.println("A是一个静态代码快");
        m = 300 ;
    }
    static int m = 100 ;
}
