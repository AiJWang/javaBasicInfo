package Study.ArraysStudy;

/**
 * @ClassName ArraysStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午5:29
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Arrays.toString：数组转化成字符串
 *
 * asList：将数组转化为list集合
 *
 * 数组变集合呢是可以使用contains等方法
 * 变成集合后，不能使用增删等操作，因为数组长度固定
 *
 * 如果数组中的数据都是对象，可以直接使用该对象的类作为泛型
 * 如果数组中的数据都是基本数据类型，必须使用int[]作为泛型,因为集合中存的是数组这个对象
 *
 * 集合变数组：
 * 1、如何定义数组长度呢，用list.size()
 * 2、为啥要集合变数组，是为了限定对元素的操作，不允许进行增删
 * */
public class ArraysStudy {
    public static void main(String[] args) {
        toStringTest();
        //数组变集合
//        toListTest();
//        //集合变数组
//        collectionToarray();
//        String a="1234";
//        System.out.println(a.substring(0,2));
    }

    public static void toStringTest(){
        int[] a={1,2,3,4};
        int[] b={1,2,4};
        System.out.println(Arrays.equals(a,b));
        System.out.println(Arrays.toString(a).substring(0,3));
        Person p1=new Person(12,"zhangsan");
        Person p2=new Person(13,"lisi");
        Person[] c={p1,p2};
        Person[] d={p1,p2};
        System.out.println(p1.hashCode()+";"+p2.hashCode());
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.equals(c,d));
        System.out.println(c==d);
    }

    public  static void toListTest(){
        int[] a={1,2,3,4};

        List<int[]> list=Arrays.asList(a);

        System.out.println(list);

        String[] b={"aa","dd","bb","cc"};

        List<String> list1=Arrays.asList(b);
        System.out.println(list1);

        boolean[] c={true,false};
        List<boolean[]> c1=Arrays.asList(c);
    }

    public  static void collectionToarray(){
        ArrayList<String> li=new ArrayList<>();
        li.add("java01");
        li.add("java02");
        li.add("java03");
        li.add("java04");

        String[] a=li.toArray(new String[3]);


        System.out.println(Arrays.toString(a));
    }
}
