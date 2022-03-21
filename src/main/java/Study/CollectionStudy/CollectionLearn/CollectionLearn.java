package Study.CollectionStudy.CollectionLearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * @ClassName CollectionLearn
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/2 下午5:57
 * @Version 1.0
 */

/**
 * 集合类collection 学习，子类接口list，set
 * Collection
 * |--List
 * |--Set
 * list子类接口 ArrayList
 * add方法的参数类型是Object
 * 集合中存储的都是对象的引用／内存地址值
 */
public class CollectionLearn {
    public static void main(String[] args) {
        //创建集合容器collection的子类ArrayList
        ArrayList al = new ArrayList();
        //添加元素
        al.add("java01");
        al.add("java02");
        al.add(1);
        System.out.println(al);
        //删除
        al.remove(1);

        //长度
        int size = al.size();
        System.out.println(size);

        System.out.println(al);
        //清空集合
        al.clear();


        System.out.println("是否为空" + al.isEmpty());

        System.out.println("-----------------");
        remainAll();

        System.out.println("---------------");
        getMember();
    }

    public static Collection remainAll() {
        ArrayList a = new ArrayList();
        a.add("java1");
        a.add("java2");
        a.add("java3");
        a.add("java1");

        ArrayList a1 = new ArrayList();
        a1.add("java1");
        a1.add("java5");
        a1.add("java4");
        a1.add("java1");

        System.out.println("a:" + a);
        System.out.println("a1:" + a1);
        //取交集，a中保留和a1中一致的元素
        a.retainAll(a1);
        System.out.println("a:" + a);
        System.out.println("a1:" + a1);
        return a;
    }

    //获取迭代器，用于取出集合中的元素
    public static void getMember() {
        ArrayList a = new ArrayList();
        a.add("java1");
        a.add("java2");
        a.add("java3");
        a.add("java1");

        Iterator it = a.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
