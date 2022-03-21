package Study.CollectionStudy.CollectionLearn.SetStudy;

/**
 * @ClassName SetStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/4 下午9:16
 * @Version 1.0
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Set:元素无序，不可重复,方法跟list一样
 * |--HashSet：底层数据结构是哈希表，如何保证元素的唯一性呢，通过hashCode和equals来完成
 * 先判断hashCode是否相同，若相同在用equals判断是否为同一个对象，所以一般都复写
 * hashCode方法和equals方法
 * 判断元素是否存在contains,和删除元素remove（）:都是根据hashCode和equals
 * |--TreeSet：可以对set集合中的元素排序，数据结构是个二叉树，左边数据小，右边大
 * 保证元素唯一性的是compareTo方法
 * TreeSet排序的第一种方式，让元素具备比较性，实现comparable接口，
 * 覆盖compareTo方法
 * <p>
 * TreeSet集合第二种排序方式
 * 当元素不具备比较性或者具备的比较性不是所需的
 * 就是让集合具备比较性，这是要定义一个比较器，将比较器传入Treeset构造函数
 * 当都存在时，此方法优先
 * 定义一个类，实现comparator接口，重写 compare方法
 * <p>
 * 按照学生年龄排序Student
 */
public class SetStudy {
    public static void main(String[] args) {
        //hashStudy();

        treeSetStudy();

    }

    public static void treeSetStudy() {
        TreeSet tree = new TreeSet();
        tree.add(new Student("zhangsan", 1));
        tree.add(new Student("lisi", 3));
        tree.add(new Student("wangwu", 5));
        tree.add(new Student("fanliu", 6));

        for (Iterator it = tree.iterator(); it.hasNext(); ) {
            Student st = (Student) it.next();
            System.out.println(st.getName() + "..." + st.getAge());
        }

    }

    public static void hashStudy() {
        HashSet hashSet = new HashSet();
        hashSet.add("java01");
        hashSet.add("java02");
        hashSet.add("java03");
        hashSet.add("java04");

        for (Iterator it = hashSet.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        HashSet hs = new HashSet();
        hs.add(new Person("zhangsan", 1));
        hs.add(new Person("lisi", 2));
        hs.add(new Person("wangwu", 3));
        hs.add(new Person("wangwu", 3));
        hs.add(new Person("fanliu", 4));

        for (Iterator it = hs.iterator(); it.hasNext(); ) {
            Person p = (Person) it.next();
            System.out.println(p.getName() + "...." + p.getAge());
        }
    }
}
