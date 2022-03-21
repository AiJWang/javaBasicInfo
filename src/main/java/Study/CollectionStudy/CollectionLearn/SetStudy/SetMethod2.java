package Study.CollectionStudy.CollectionLearn.SetStudy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ClassName SetMethod2
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/7 上午11:35
 * @Version 1.0
 */
public class SetMethod2 {
    public static void main(String[] args) {
        //hashStudy();

        treeSetStudy();

    }

    public static void treeSetStudy() {
        //此时就是按照MTreeSet这种设置的规则排序的
        TreeSet tree = new TreeSet(new MTreeSet());
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
