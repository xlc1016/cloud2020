package com.xlc;


import java.util.concurrent.atomic.AtomicInteger;

/**
* @author :xlc
* @date: 2020-4-17
* @description:  cas == compareAndSet
*/
public class CASDemo
{
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(2);
        System.out.println(atomicInteger.compareAndSet(2, 5)+"\t" +"current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2, 15)+"\t" +"current data:"+atomicInteger.get());

        //解决i++在多线程下出错问题
        atomicInteger.getAndIncrement();

        System.out.println(Integer.MAX_VALUE);
    }


}
