package com.xlc.springcloud;

public class Dog extends Animal {

    public static void main(String[] args){
            Dog dog = new Dog();
      //  System.out.println(dog.getClass().getName());
        //输出com.kang.Dog
    //    System.out.println(Animal.class.getName());

    //    System.out.println(Object.class);


        String n = "1";
        Class<? extends String> c = n.getClass();
        System.out.println( n.getClass());
        //输出com.kang.Animal
    }
}
