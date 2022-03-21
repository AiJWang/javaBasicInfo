package Study.CollectionStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ForStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午6:21
 * @Version 1.0
 */

/**
 * 高级for循环
 *
 * for(数据类型 变量名: Collections集合或者数组){}
 * 可以不使用Iterator迭代器
 * */
public class ForStudy {
    public static void main(String[] args) {
        ArrayList<String> li=new ArrayList<>();
        li.add("java01");
        li.add("java02");
        li.add("java03");
        li.add("java04");
        li.add("java05");

        for (String s:li){
            System.out.println(s);
        }

        int[] arr={1,23};
        for (int i:arr){
            System.out.println(i);
        }

        HashMap<String,String> hs=new HashMap<>();
        hs.put("java01","python01");
        hs.put("java02","python02");
        hs.put("java03","python03");
        hs.put("java04","python04");

        //keySet
        for (String i: hs.keySet()){
            System.out.println(hs.get(i));
        }
        //entrySet
        for (Map.Entry<String,String> ma:hs.entrySet()){
            System.out.println(ma.getKey()+"..."+ma.getValue());
        }

    }
}
