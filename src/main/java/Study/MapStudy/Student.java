package Study.MapStudy;

/**
 * @ClassName Student
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/8 上午10:33
 * @Version 1.0
 */
public class Student implements Comparable<Student> {
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
        return this.getAge();
    }

    public int hashCode() {
        return name.hashCode() + age * 35;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            throw new ClassCastException("不是student类型");
        Student st = (Student) obj;
        return name.equals(st.name) && (age == st.age);
    }

    public int compareTo(Student student) {
        int num = name.compareTo(student.name);
        if (num == 0) {
            return (new Integer(age).compareTo(new Integer(student.age)));
        }
        return num;
    }
}
