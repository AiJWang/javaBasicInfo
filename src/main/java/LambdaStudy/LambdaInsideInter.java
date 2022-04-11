package LambdaStudy;

import NewLei.PersonA;
import Study.ArraysStudy.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * java8 4大核心函数式接口
 *
 * ① Consumer<T>: 消费型接口
 *      void accept(T t);
 *②Supplier：供给行接口
 *      T get()
 *③Function<T,R> 函数型接口
 *      R apply(T t)
 *④Predica<T> 断言型接口
 *      boolean test(T,t);
 * */
public class LambdaInsideInter {
    public static void main(String[] args) {
        //consumer 接口测试,暂时没想到应用场景
        consumerTest("age",x-> {
            String c="hello";
            String d=" test accept";
            StringBuffer sb=new StringBuffer();
            sb.append(x).append(c).append(d);
            System.out.println(sb);

        });
        System.out.println("-----------------------");
        Person person=new Person();
        consumerTest1(person,x->{
            person.setAge(13);
            person.setName("aj");
        });
        System.out.println(person.getName());
        System.out.println("-----------------------");
        List<Integer> supplierTestcase=supplierTest(10, ()-> {
            Person p=new Person(12,"hello");
            return p.getAge();
        });
        supplierTestcase.forEach(System.out::println);
    }
    public static void consumerTest(String a, Consumer<String> c){
       c.accept(a);
    }
    public static <T> void consumerTest1(T a, Consumer<T> c){
        c.accept(a);
    }
    //用supplier返回的数据，放到list中
    public static List<Integer> supplierTest(int a, Supplier<Integer> c){
        List<Integer> d=new ArrayList<>();
        if (a>10){
            d.add(c.get());
        }else {
            d.add(c.get());
        }
        return d;
    }
}
