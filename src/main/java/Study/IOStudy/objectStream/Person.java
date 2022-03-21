package Study.IOStudy.objectStream;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:05
 * @Version 1.0
 */
//必须实现可序列化这个接口，但是这个接口没有方法
    // 重要：静态内容无法被序列化
    //被transient 修饰，也无法被被序列化
public class Person implements Serializable {
    private int age;
    private String name;
    //无法被序列化
    public static String coutry;

    //被transient 修饰，也无法被被序列化
    transient int weight;

    Person(String name,int age)
    {
        this.age=age;
        this.name=name;
    }
    public String toString(){
        return name+": "+age;
    }
}
