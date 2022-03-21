package LambdaStudy;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * LambdaInsideInter:java8 有内置的函数式接口，基本不用自己创建
 * java8 Lambda 表达式，都需要一个接口，Lambda相当于实现接口的方法
 * Lambda 表达式需要  函数式接口  的支持：接口中只有1个抽象方法的接口，可以使用注解@FunctionalInterface修饰一下。
 * 注意:如果引用了同级的变量，该变量是final的，不能修改
 * 语法格式：
 *    无参，无返回值：
 *          Runnable runnable=()-> System.out.println("hello lambda"+a);
 *    一个参数，无返回值：
 *          Consumer<String> consumer=x-> System.out.println(x);
 *    多个参数，有返回值，并且有多条lambda语句：
 *          Comparator<Integer> c=(x,y)->{
 *             System.out.println("多条语句");
 *             return Integer.compare(x,y);
 *         };
 *    多个参数，有返回值，但是只有1条语句大括号和return可以省略
 *          Comparator<Integer> c=(x,y)-> Integer.compare(x,y);
 * */
public class LambdaJava8Test {
    public static void main(String[] args) {
        test4();
    }
    //无参 并且无返回值 lambda
    public static void test(){
        int a=0;
        //匿名内部类
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                int b=a+1;
                System.out.println("hello lambda");
            }
        };
        runnable1.run();
        System.out.println("==========================");
        //相当于直接实现Runnable接口的run方法
        //不允许在里面修改 Runnable runnable=()-> System.out.println("hello lambda"+a++);
        Runnable runnable=()-> System.out.println("hello lambda"+a);
        runnable.run();
    }
    //一个参数 无返回值
    public static void test1(){
        //实现Consumer accept接口
        Consumer<String> consumer=x-> System.out.println(x);
        consumer.accept("hello Lambda");
    }
    //个参数，有返回值，并且有多条lambda语句。多条语句需要加入大括号
    public static void test2(){
        Comparator<Integer> c=(x,y)->{
            System.out.println("多条语句");
            return Integer.compare(x,y);
        };
    }
    //多个参数，有返回值，但是只有1条语句大括号和return可以省略
    public static void test3(){
        Comparator<Integer> c=(x,y)-> Integer.compare(x,y);
    }
    //把传入的字符转成大写
    public static void test4(){
        String a="hello java lambda";
        //把传入的字符转成大写
        String b= upCase(a,x->x.toUpperCase());
        System.out.println("b: "+b);
        //获取子字符串
        String c=upCase(a,x->x.substring(2,5));
        System.out.println(c);
        //两个泛型，x*2+y
        long d=getLongTest(100L,400L,(x,y)->x*2+y);
        System.out.println(d);
    }
    public static String upCase(String a,UpWords upWords){
        return upWords.upWords(a);
    }
    public static long getLongTest(long a,long b,TwoFanXingInter<Long,Long> t){
        return t.getk(a,b);
    }
}
