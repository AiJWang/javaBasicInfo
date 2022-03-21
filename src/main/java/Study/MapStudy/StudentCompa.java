package Study.MapStudy;

import java.util.Comparator;

/**
 * @ClassName StudentCompa
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/8 下午12:42
 * @Version 1.0
 */
public class StudentCompa implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0)
            return (new Integer(s1.getAge()).compareTo(new Integer(s2.getAge())));
        return num;
    }
}
