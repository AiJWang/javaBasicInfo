package LambdaStudy;

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
        consumerTest("age",x-> System.out.println(x));
        List<Integer> supplierTestcase=supplierTest(10, ()-> (int) (Math.random() * 100));
        supplierTestcase.forEach(System.out::println);
    }
    public static void consumerTest(String a, Consumer<String> c){
       c.accept(a);
    }
    //用supplier返回的数据，放到list中
    public static List<Integer> supplierTest(int a, Supplier<Integer> c){
        List<Integer> d=new ArrayList<>();
        for (int i=0;i<a;i++){
            int b=c.get();
            d.add(b);
        }
        return d;
    }
}
