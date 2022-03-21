package Study.CollectionStudy.CollectionLearn.SetStudy;

/**
 * @ClassName Student
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/4 下午11:22
 * @Version 1.0
 */
public class Student implements Comparable //该接口强制让学生有比较性
{
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是学生对象");
        }
        Student st = (Student) obj;
        if (this.age > st.age)
            return 1;
        if (this.age == st.age)
            return this.name.compareTo(st.name);
        return -1;
    }

}
