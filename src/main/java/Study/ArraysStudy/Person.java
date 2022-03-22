package Study.ArraysStudy;

import java.util.Objects;

/**
 * @ClassName Person
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/7 下午3:32
 * @Version 1.0
 */

public class Person {
    private int age;
    private String name;
    public Person(){}

    public Person(int age,String name){
        this.age=age;
        this.name=name;
    }

    public Person(Integer age,String name){
        this.age=age;
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }
}
