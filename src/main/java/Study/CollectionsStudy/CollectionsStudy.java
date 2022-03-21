package Study.CollectionsStudy;

/**
 * @ClassName CollectionsStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午4:12
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合框架的工具类 Collections
 *
 * Collections.sort
 * Collections.max
 * Collections.binarySearch
 * Collections.replaceAll
 * Colections.reverse
 *
 * Collections.reverseOrder:返回一个比较器，按反序排列Collections.reverseOrder、
 * Collections.reverseOrder（new com()）
 *
 * Collections.swap(Collections,int,int)：交换位置
 * Collections.shuffle(Collecions):随机对元素重新摆列
 * */
public class CollectionsStudy {
    public static void main(String[] args) {
        sortTest();

        fileDemo();

        replaceAllTest();

        List<String> list=new ArrayList<String>();
        list.add("qwe");
        list.add("bb");
        list.add("aaaa");
        list.add("bbac");
        System.out.println("================");
        fileDemo(list,1,3,"new");
    }

    public static void sortTest(){
        List<String> list=new ArrayList<String>();
        list.add("qwe");
        list.add("bb");
        list.add("aaaa");
        list.add("bbac");

        System.out.println(list);

        Collections.sort(list);

        System.out.println("==============");
        System.out.println(list);

        Collections.sort(list,new StringLenCom());

        System.out.println("=============");
        System.out.println(list);

        System.out.println(Collections.max(list));

        System.out.println(Collections.binarySearch(list,"bb"));

        System.out.println(list.get(0));

    }

    public static void fileDemo(){
        List<String> list=new ArrayList<String>();
        list.add("qwe");
        list.add("bb");

        System.out.println(list);

        Collections.fill(list,"replace");
        System.out.println(list);
    }

    public static void fileDemo(List<String> list,int start,int end,String newCha){

        System.out.println(list);
        List<String> list1=list.subList(start,end);
        System.out.println("list1: "+list1);
        Collections.fill(list1,newCha);
        System.out.println("list1: "+list1);
        System.out.println(list);


    }

    public static void replaceAllTest(){
        List<String> list=new ArrayList<String>();
        list.add("qwe");
        list.add("bb");
        System.out.println(list);
        Collections.replaceAll(list,"bb","aa");

        System.out.println(list);
    }
}
