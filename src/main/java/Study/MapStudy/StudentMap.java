package Study.MapStudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName StudentMap
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/8 上午10:49
 * @Version 1.0
 */
public class StudentMap {
    public static void main(String[] args) {
        HashMap<Student, String> hs = new HashMap<>();
        hs.put(new Student("aaa", 10), "beijing");
        hs.put(new Student("bbb", 11), "tianjin");
        hs.put(new Student("ccc", 12), "shanghai");
        hs.put(new Student("ddd", 13), "changsha");

        Set<HashMap.Entry<Student, String>> hsE = hs.entrySet();
        for (Iterator it = hsE.iterator(); it.hasNext(); ) {
            HashMap.Entry<Student, String> e = (HashMap.Entry<Student, String>) it.next();
            System.out.println(e.getKey() + "...." + e.getValue());
        }
        System.out.println("----------");
        Set<Student> st = hs.keySet();
        for (Iterator<Student> iterator = st.iterator(); iterator.hasNext(); ) {
            Student s = iterator.next();
            System.out.println(s + "....." + hs.get(s));
        }
    }
}
