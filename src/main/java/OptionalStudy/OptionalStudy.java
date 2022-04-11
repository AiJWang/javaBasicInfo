package OptionalStudy;

import StreamAPIStudy.Employee;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Optional 容器类常用方法
 * Optional.of(T t) 创建一个Optional实例
 * Optional.empty() 创建一个空的Optional
 * Optional.ofNullable(T t):若t不为null，创建t的Optional实例，否则创建空实例
 *  isPresent():判断optional是否有值
 *  orElse(T t)，判断optional是否有值，有值返回optional中的值，否则返回默认值 t
 *  orElseGet(Supplier s),判断是否有值，若没有值，返回supplier返回值
 *  map(Function f) :如果option有值，处理每个值，返回处理后的optional，否则返回 optional.empty
 *  flatMap(Function f):与map类似，返回值必须是optional
 * */
public class OptionalStudy {
    public static void main(String[] args) {
        test2();
        System.out.println("----------------------");
        //test1();
        System.out.println("------------------");
        testMan();
    }
    public static void test1(){
        //创建一个optional实例
        Optional<Employee> optional= Optional.of(new Employee());
        Employee e= optional.get();
        System.out.println(e);
        //of
        Optional<Employee> optional1 = Optional.ofNullable(null);
        Employee e1=optional1.orElse(new Employee("zhangsan",12,44.22, Employee.Status.BUSY));
        System.out.println(e1);
        Employee e2=optional1.orElseGet(()->new Employee("lisi",22,33, Employee.Status.BUSY));
        System.out.println(e2);

        System.out.println();
        System.out.println(optional1.get());
        //创建一个空的Optional,此时直接get会报空指针
        Optional<Employee> op=Optional.empty();
        //判断有值才会往下走
        if (op.isPresent()){
            System.out.println(op.get());
        }

    }

    //map flatMap test
    public static void test2(){
        Optional<Employee> op=Optional.of(new Employee("zhangsan",12,44.22, Employee.Status.BUSY));
        //请看map和flatmap的区别
        Optional<String> name =op.map(e->e.getName());
        Optional<String> name1 =op.flatMap(e->Optional.of(e.getName()));
        System.out.println(name1.get());
        System.out.println(name.get());
    }
    //应用场景
    public static void testMan(){
        Optional<Man> m=Optional.of(new Man());
        String a=getGodName(m);
        System.out.println("a: "+a);
    }
    //获取女神名字
    public static String getGodName(Optional<Man> man){
        return man.orElse(new Man())
                .getGod()
                .orElse(new Godness())
                .getName();
    }
}
