package StreamAPIStudy;

import Study.ArraysStudy.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream basic info
 * stream是形成新的流，不会对源数据有影响
 * 使用的3个步骤
 * ①创建steam
 * ②中间操作：多个中间操作连接形成流水线，但是除非触发终止操作，否则中间操作不会执行任何语句，而在终止操作是一次性执行全部，称为惰性求值
 *      filter:筛选切片 接收lambda,从流中排除某些元素
 *      limit：截断流，使其元素不超过设置的数量
 *      skip(n)：跳过元素，返回去掉前n个元素的流，若流中元素不足n个，返回一个空流，与limit互补.跳过的是过滤后的流
 *      distinct：去重，通过流所生成的元素的hashCode（）和equals（）进行去重。
 *      map：映射，接收一个lambda（Function类型的），接收一个函数作为参数，将其作用到每个元素上，并将其形成新的元素
 *      flatmap；跟map类似，接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个流（跟map的区别是，map把函数返回的流加到流中，
 *      形成流中流。flatmap是吧函数返回的流中的每个数据，加到自己的流中，最后只是一个流，类似addAll。具体见示例）
 *      sort():自然排序
 *      sort(Comparator c)：定制排序
 * ③终止操作
 * */
public class StreamBasicStudy {
    public static void main(String[] args) {
        sortTest();
    }
    //创建流，4种方式
    public static void testCreateStream(){
        //方法1：通过Collection系列集合stream()或parallelStream
        List<String> list=new ArrayList<>();
        Stream<String> stream=list.stream();
        //方法2：通过Arrays中静态方法stream获取数组流
        Stream<Person> stream1= Arrays.stream(new Person[10]);
        //方法3：Stream静态方法of
        Stream<String> stream2=Stream.of("aa","bb","cc");
        //方法4：创建无限流，2种方式
        //迭代方式,从0开始，按照一元运算，执行+2操作，一直进行
        Stream<Integer> stream3=Stream.iterate(0,x->x+2);
        stream3.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
    //filter test,过滤大于20岁的人
    public static void filterTest(){
        List<Person> persons=Arrays.asList(
                new Person(12,"AJ"),
                new Person(22,"qq"),
                new Person(26,"bb"),
                new Person(26,"bb"),
                new Person(33,"cc"),
                new Person(26,"bb"),
                new Person(33,"cc"),
                new Person(34,"dd"),
                new Person(88,"gg")
        );
        //中间操作
        Stream<Person> p=persons.stream().filter(x->{
            System.out.println("中间操作"+x.getName());
            return x.getAge()>20;})
                .skip(2)
                .distinct()
                .limit(10);
        //终止操作
        p.forEach(x-> System.out.println(x.getName()));
    }
    // map
    public static void mapTest(){
        List<String> l=Arrays.asList("aa","bb");
        l.stream().map(String::toUpperCase)
                .forEach(System.out::println);
    }
    //flatmap
    public static void testFlatMap(){
        List<String> list=Arrays.asList("aa","vv");
        //先看map,返回的是流中还是流
        Stream<Stream<Character>> c=list.stream().map(StreamBasicStudy::getChara);
        //flatMap,将所有流，汇总成一个，类似addAll方法
        Stream<Character> s=list.stream().flatMap(StreamBasicStudy::getChara);
        c.forEach(x->x.forEach(System.out::println));
        System.out.println("----------------------------------");
        s.forEach(System.out::println);
    }

    public static Stream<Character> getChara(String s){
        List<Character> l=new ArrayList<>();
        for (Character c:s.toCharArray()){
            l.add(c);
        }
        return l.stream();
    }
    //sort test
    public static void sortTest(){
        //自然排序
        List<String> list=Arrays.asList("vv","aa","dd","cc");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------");
        //定制排序
        List<Person> persons=Arrays.asList(
                new Person(12,"AJ"),
                new Person(22,"qq"),
                new Person(22,"bb"),
                new Person(37,"cc"),
                new Person(33,"dd"),
                new Person(33,"gg")
        );
        persons.stream().sorted((e1,e2)->{
            if (e1.getAge()== e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(), e2.getAge());
        }).forEach(s-> System.out.println(s.getName()));
    }
}
