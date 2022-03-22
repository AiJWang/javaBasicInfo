package LambdaStudy;

import Study.ArraysStudy.Person;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若lambda体中内容已经有方法已经实现了，可使用“方法引用”（可理解为方法引用是lambda表达式的另一种表现形式）
 * 主要有三种格式
 *
 * 对象::实例方法
 *
 * 类::静态方法
 *
 * 类::实例方法
 *
 * 构造器引用
 * ClassName::new
 * */
public class FangFaYinYong {
    public static void main(String[] args) {
        testConsumer("aa");
        testSupplier();
        test2();
    }
    //对象::实例方法
    public static void testConsumer(String ss){
        Consumer<String> s= System.out::println;
        s.accept(ss);
    }
    public static void testSupplier(){
        Person p=new Person(12,"aj");
        Supplier<String> name=p::getName;
        String n=name.get();
        System.out.println(n);
    }
    //类::静态方法
    public static void test(){
        //两者等同
        Comparator<Integer> c=(x,y)->Integer.compare(x,y);
        Comparator<Integer> cc=Integer::compare;
    }
    //类::实例方法
    public static void test1(){
        BiPredicate<String,String> b=(x,y)->x.equals(y);
        //当第一个参数x是此方法的调用者，y是此方法的参数时，可以用类::示例方法形式
        BiPredicate<String,String> c=String::equals;
    }
    //构造器引用,需要引用的构造器的参数列表与构造函数中参数列表一致
    public static void test2(){
        //无参构造
        Supplier<Person> s=()->new Person();
        Person ss=s.get();
        Supplier<Person> s1=Person::new;
        Person ss1=s1.get();
        System.out.println(ss);
        System.out.println(ss1);
        //两个参数构造
        BiFunction<Integer,String,Person> a=(x,y)->new Person();
        Person a1=a.apply(12,"aj");
        BiFunction<Integer,String,Person> aa=Person::new;
        Person aa1=aa.apply(12,"aj1");
        System.out.println(a1.getName());
        System.out.println(aa1.getName());
    }
}
