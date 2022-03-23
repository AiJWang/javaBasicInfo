package StreamAPIStudy;

import Study.ArraysStudy.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream basic info
 * stream是形成新的流，不会对源数据有影响
 * 使用的3个步骤
 * ①创建steam
 * ②中间操作：多个中间操作连接形成流水线，但是除非触发终止操作，否则中间操作不会执行任何语句，而在终止操作是一次性执行全部，称为惰性求值
 * filter:筛选切片 接收lambda,从流中排除某些元素
 * limit：截断流，使其元素不超过设置的数量
 * skip(n)：跳过元素，返回去掉前n个元素的流，若流中元素不足n个，返回一个空流，与limit互补.跳过的是过滤后的流
 * distinct：去重，通过流所生成的元素的hashCode（）和equals（）进行去重。
 * map：映射，接收一个lambda（Function类型的），接收一个函数作为参数，将其作用到每个元素上，并将其形成新的元素
 * flatmap；跟map类似，接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个流（跟map的区别是，map把函数返回的流加到流中，
 * 形成流中流。flatmap是吧函数返回的流中的每个数据，加到自己的流中，最后只是一个流，类似addAll。具体见示例）
 * sort():自然排序
 * sort(Comparator c)：定制排序
 * ③终止操作
 * 查找与匹配：
 * boolean allMatche ---检查是否匹配所有元素
 * boolean anyMatch ---是否匹配至少一个元素
 * boolean noneMatch ---是否一个元素都没匹配
 * Optional<T> findFirst --返回第一个
 * Optional<T> findAny   --随便找一个符合的
 * count --流中元素个数
 * max --流中元素最大值
 * min --六中元素最小值
 * 归约
 * T reduce(T identity,BinaryOperator b) --给定一个起始值，用起始值为x，遍历所有元素，进行二运操作，每次遍历都将结果当做下一个起始值，
 * Optional reduce(BinaryOperator b)  --无起始值
 * 收集
 * collect(Collector) : 将集合中元素以其他形式收集起来
 *  Colector是一个接口，有现成的实现类，Collectors
 */
public class StreamBasicStudy {
    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 58, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 26, 3333.99, Employee.Status.HOME),
            new Employee("赵六", 36, 6666.99, Employee.Status.FREE),
            new Employee("田七", 12, 8888.55, Employee.Status.BUSY));

    public static void main(String[] args) {
        allMatchTest();
        System.out.println("-----------------------------");
        reduceTest();
        System.out.println("-----------------------------");
        collectTest();
    }

    //创建流，4种方式
    public static void testCreateStream() {
        //方法1：通过Collection系列集合stream()或parallelStream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //方法2：通过Arrays中静态方法stream获取数组流
        Stream<Person> stream1 = Arrays.stream(new Person[10]);
        //方法3：Stream静态方法of
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        //方法4：创建无限流，2种方式
        //迭代方式,从0开始，按照一元运算，执行+2操作，一直进行
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        stream3.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    //filter test,过滤大于20岁的人
    public static void filterTest() {
        List<Person> persons = Arrays.asList(
                new Person(12, "AJ"),
                new Person(22, "qq"),
                new Person(26, "bb"),
                new Person(26, "bb"),
                new Person(33, "cc"),
                new Person(26, "bb"),
                new Person(33, "cc"),
                new Person(34, "dd"),
                new Person(88, "gg")
        );
        //中间操作
        Stream<Person> p = persons.stream().filter(x -> {
            System.out.println("中间操作" + x.getName());
            return x.getAge() > 20;
        })
                .skip(2)
                .distinct()
                .limit(10);
        //终止操作
        p.forEach(x -> System.out.println(x.getName()));
    }

    // map
    public static void mapTest() {
        List<String> l = Arrays.asList("aa", "bb");
        l.stream().map(String::toUpperCase)
                .forEach(System.out::println);
    }

    //flatmap
    public static void testFlatMap() {
        List<String> list = Arrays.asList("aa", "vv");
        //先看map,返回的是流中还是流
        Stream<Stream<Character>> c = list.stream().map(StreamBasicStudy::getChara);
        //flatMap,将所有流，汇总成一个，类似addAll方法
        Stream<Character> s = list.stream().flatMap(StreamBasicStudy::getChara);
        c.forEach(x -> x.forEach(System.out::println));
        System.out.println("----------------------------------");
        s.forEach(System.out::println);
    }

    public static Stream<Character> getChara(String s) {
        List<Character> l = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            l.add(c);
        }
        return l.stream();
    }

    //sort test
    public static void sortTest() {
        //自然排序
        List<String> list = Arrays.asList("vv", "aa", "dd", "cc");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------");
        //定制排序
        List<Person> persons = Arrays.asList(
                new Person(12, "AJ"),
                new Person(22, "qq"),
                new Person(22, "bb"),
                new Person(37, "cc"),
                new Person(33, "dd"),
                new Person(33, "gg")
        );
        persons.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(), e2.getAge());
        }).forEach(s -> System.out.println(s.getName()));
    }

    //--------------------------终止操作------------------------
    public static void allMatchTest() {
        //是否所有人都是busy，返回boolean
        boolean b=employees.stream()
                .allMatch(x->x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        //是否有一个匹配
        boolean c=employees.stream()
                .anyMatch(x->x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(c);
        //是否一个元素都不匹配
        boolean d=employees.stream()
                .noneMatch(x->x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(d);
        //获取第一个
        Optional<Employee> op=employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(op.get());
        //随便获取一个
        Optional<Employee> op1=employees.stream()
                .filter(x->x.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op1.get());
        //总数
        Long l=employees.stream().count();
        System.out.println(l);
        //根据工资排序，获取工资最小的
        Optional<Employee> op2= employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(op2.get());
        //根据工资排序，获取工资最大的
        Optional<Employee> op3= employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(op3.get());
        //获取最小工资数
        Optional<Double> sa=employees.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);
        System.out.println(sa.get());

    }

    //reduce test
    public static void reduceTest(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //① 0等于x，第一个元素1，等于y，计算x+y=1，此时结果1作为x，2作为y，进行x+y=3,3再作为x，以此类推
        int a=l.stream().reduce(0,(x,y)->x+y);
        System.out.println(a);
        Optional<Double> d=employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(d.get());
    }
    // collect test
    public static void collectTest(){
        //生成list
        List<String> l=employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        l.forEach(System.out::println);
        //工资平均值
        double avg=employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }
}
