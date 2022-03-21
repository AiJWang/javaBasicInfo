package Study.MapStudy;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName TreeMapTest
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/8 下午12:35
 * @Version 1.0
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Student, String> hs = new TreeMap<Student, String>(new StudentCompa());
        hs.put(new Student("aaa", 10), "beijing");
        hs.put(new Student("bbb", 11), "tianjin");
        hs.put(new Student("aa", 12), "shanghai");
        hs.put(new Student("ddd", 13), "changsha");

        Set<Student> s1 = hs.keySet();
        for (Iterator it = s1.iterator(); it.hasNext(); ) {
            Student key = (Student) it.next();
            System.out.println(key + ".........." + hs.get(key));
        }

        Set<Map.Entry<Student, String>> ma = hs.entrySet();
        for (Iterator<Map.Entry<Student, String>> it = ma.iterator(); it.hasNext(); ) {
            Map.Entry<Student, String> entry = it.next();
            System.out.println(entry.getKey() + "....." + entry.getValue());
        }

    }
}
