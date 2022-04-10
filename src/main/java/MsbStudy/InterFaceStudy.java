package MsbStudy;

/**
 * 接口学习：
 * 1、接口没有构造器
 * JDK1.8之前，接口中只有两类数据：
 *  ① 常量： public static final int a=100;
 *  ② 抽象方法：public abstract void eat();
 *  只是写的时候系统自动补全了，可以不写了
 * JDK 1.8之后新增数据：
 *      ①public defaule 方法名（）：此方法是非抽象方法，有方法体
 *      ②静态方法
 *      如果子类需要调固定接口default方法， 则需要写 Interface.super.fangfaming
 *  一个类实现接口的时候，必须实现所有接口
 *  java 单继承 多实现（可以多实现的原因,因为即使两个实现的接口中都有相同方法，需要实现，但是都没有方法体，方法体只在类中有，所以不影响）
 *
 *
 *  重点：
 *  什么时候用继承，什么时候用实现
 *  例：手机是不是照相机机
 *  继承：手机extends 照相机  is-a 的关系，手机是一个照相机
 *  实现 手机 implements 照相机   has-a的关系   手机具备照相的能力
 * */
public interface InterFaceStudy {
    int a=100;

    void say();
    static void eat(){
        System.out.println("run ......");
    }
}

 interface InterfaceStudy1{
    void say();
    default void eat(){
        System.out.println("吃米饭");
    }
}

class Student implements InterFaceStudy,InterfaceStudy1 {
    @Override
    public void say(){
        System.out.println("test");
    }

    public void test(){
        InterFaceStudy.eat();
        InterfaceStudy1.super.eat();
    }
}