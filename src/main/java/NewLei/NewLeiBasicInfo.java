package NewLei;
/**
 * java8 中，接口中可以有默认方法 default
 * 当一个类继承了父类方法，实现一个接口，并且两者有相同方法时，直接选择父类方法
 * 当一个类实现了两个接口，两个接口有相同的default方法，则必须重写改方法
 * */
public class NewLeiBasicInfo {
    public static void main(String[] args) {
        PersonHasFather j=new PersonHasFather();
        System.out.println(j.getName());
        PersonImpTwo p=new PersonImpTwo();
        System.out.println(p.getName());
        System.out.println("------------------");
        PersonFather a=new Student();
        System.out.println(((Student)a).getAge());
    }
}
