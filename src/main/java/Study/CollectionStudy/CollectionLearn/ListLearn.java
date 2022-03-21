package Study.CollectionStudy.CollectionLearn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * @ClassName ListLearn
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/2 下午7:32
 * @Version 1.0
 */

/**
 * Collection
 * |--List:元素有序，可重复，有索引
 * |--ArrayList:数组结构，查询快，增删慢，线程不同步
 * |--LinkedList：链表结构，查询慢，增删快
 * |--Vector：数组结构，同ArrayList，线程同步，被ArrayList取代
 * |--Set：元素无序，不可重复
 * <p>
 * List：
 * 增
 * add(index,element)
 * addAll(index,Collection)
 * <p>
 * 删
 * remove(index)
 * remove(Obj)
 * <p>
 * 改
 * set(index,element)
 * <p>
 * 查
 * get(index)
 * subList(start,end)
 * listIterator()
 * <p>
 * List集合特有的迭代器，ListIterator是Iterator的子接口
 * 在迭代时，不能用集合的方式操作集合中的元素，会发生异常
 * 所以在迭代时，只能通过迭代器的方式操作集合元素
 * <p>
 * 包含：contains
 * List集合：list是否包含某个元素，list.contains(obj)，实际是用obj.equals(list中每个元素)，
 * 比较的是内存地址值
 */
public class ListLearn {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        //添加元素
        al.add("java01");
        al.add("java02");
        al.add(1);

        System.out.println("原集合" + al);
        //添加
        al.add(1, "java03");
        System.out.println("---" + al);

        //获取对象位置
        System.out.println(al.indexOf(1));
        //获取子列表
        List sub = al.subList(0, 2);
        System.out.println("sub:" + sub);
        for (int i = 0; i < sub.size(); i++)
            System.out.println(sub.get(i));
        //删除
        al.remove("java01");
        System.out.println("-------" + al);
        al.remove(1);
        System.out.println("-------" + al);
        //获取1个
        System.out.println("1号位" + al.get(1));
        System.out.println(al);
        //获取所有Iterator
        for (Iterator it = al.iterator(); it.hasNext(); ) {
            System.out.println("next " + it.next());
        }
        ArrayList al1 = new ArrayList();
        //添加元素
        al1.add("java01");
        al1.add("java02");
        al1.add(1);

        ListIterator listIterator = al1.listIterator();

        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            System.out.println("---------");
            System.out.println(listIterator.previousIndex());
            System.out.println(listIterator.nextIndex());
            System.out.println(object);
            if (object.equals("java01"))
                listIterator.add("java03");


        }
        System.out.println("al1:" + al1);

    }
}
