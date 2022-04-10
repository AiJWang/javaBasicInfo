package MsbStudy;

/**
 * 抽象类：
 * 一个类中如果有1个抽象方法，那么这个类也要变成抽象方法
 * 一个抽象方法中可以有0-n个抽象方法
 *抽象类可以被继承，但是子类必须重写全部抽象方法，若是子类没有重写全部的抽象方法，子类可以变为抽象类
 * 抽象类不可以创建对象
 * */
public abstract class AbstractClassTest {
    public void eat(){
        System.out.println("一顿不吃饿得慌");
    }
    public abstract void say(String a);
}

class stuent extends AbstractClassTest{
    @Override
    public void say(String a){
        System.out.println("中国人说中国话"+a);
    }
}