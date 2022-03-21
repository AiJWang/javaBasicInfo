package Study.CollectionStudy.CollectionLearn.SetStudy;

import java.util.Comparator;

/**
 * @ClassName MTreeSet
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/7 上午11:29
 * @Version 1.0
 */
public class MTreeSet implements Comparator {
    public int compare(Object obj1, Object obj2) {
        Student s1 = (Student) obj1;
        Student s2 = (Student) obj2;
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0)
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
        return num;
    }
}
