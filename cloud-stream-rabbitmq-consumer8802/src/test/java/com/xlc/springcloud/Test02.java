package com.xlc.springcloud;


import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
* @author :xlc
* @date: 2020-4-26
* @description: 通过反射获取注解
*/
public class Test02
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 获取类
        Class c1 = Class.forName("com.xlc.springcloud.User");
//        String name = c1.getName();
//        System.out.println(name);

        // 获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获取注解的value值
        User.MyUserTable annotation =(User.MyUserTable) c1.getAnnotation(User.MyUserTable.class);
        System.out.println(annotation.value());
        // 获得类指定的注解
        Field fieldName = c1.getDeclaredField("name");
        User.MyUserField annotation1 = fieldName.getAnnotation(User.MyUserField.class);
        System.out.println(annotation1.coloumName());
        System.out.println(annotation1.longth());
        System.out.println(annotation1.type());

    }
}
@User.MyUserTable("db_user")
class User{
    @MyUserField(coloumName = "user_id",type = "int",longth = 10)
    private  int  id;
    @MyUserField(coloumName = "user_name",type = "varchar" ,longth = 5)
    private String name;
    @MyUserField(coloumName = "user_age",type = "int",longth = 5)
    private int  age;

  public User(){}


    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    // 类名的注解
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyUserTable{
      String value();
    }
    // 属性的注解
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface  MyUserField{
        String coloumName();
        String type();
        int longth();

    }
}
