package Study.CollectionStudy.CollectionLearn.SetStudy;

/**
 * @ClassName Person
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/4 下午10:21
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //建立自己的hash值,所有对象生成hash值都是60
    public int hashCode() {
        return 60;
    }

    //重写equals方法，HashSet 添加元素时，先判断hash值是否一致，再调用此方法判断元素是否已存在
    public boolean equals(Object obj) {
        if (!(obj instanceof Person))
            return false;
        Person p = (Person) obj;
        System.out.println(this.name + "...equals..." + p.getName());
        return this.getName().equals(p.name) && this.age == p.age;
    }
}
