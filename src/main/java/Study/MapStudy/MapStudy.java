package Study.MapStudy;

/**
 * @ClassName MapStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/7 下午1:01
 * @Version 1.0
 */

import java.util.*;

/**
 * Map跟Collection是同一层级的
 * <p>
 * Map<K,V> K:键值  V：value值，键值唯一
 * 添加元素:
 * put(key,value)
 * putAll(Map<? extends K,? extends V>m)
 * 删除元素：
 * clear()
 * remove(key)
 * 判断元素：
 * containsKey(key)
 * containsValue(value)
 * isEmpty()
 * 获取元素：
 * get(key)
 * size()
 * values() 所有的值
 * <p>
 * Map
 * |--HashTable:底层是hash表不可存入null建null值，集合同步（已经被HashMap取代了）
 * |--HashMap:底层是哈希表数据接口，允许使用null键null值，集合不同步
 * |--TreeMap：二叉树数据结构，线程不同步，可以用户给map键值排队
 * <p>
 * Set<key> keySet:将Map中所有键存入set集合，因为set具备迭代器，可以迭代取出所有的键
 * Set<map.Entry<K,V>> entrySet: 将map集合中映射关系存入到了set集合中，这个关系的数据类型就是 map.Entry
 **/
public class MapStudy {
    public static void main(String[] args) {
        MapFirst();
        System.out.println("-----------");
        ketSetStudy();
        System.out.println("-----------");
        entrySetStudy();
    }

    public static void MapFirst() {
        Map<String, String> map = new HashMap<String, String>();
        //添加元素
        map.put("01", "zhang1");
        map.put("02", "zhang2");
        map.put("03", "zhang3");

        System.out.println("containsKey:" + map.containsKey("01"));

        map.remove("01");

        System.out.println(map.containsKey("01"));

        //获取所有key值
        Collection<String> co = map.values();
        System.out.println("co...." + co);
    }

    public static void ketSetStudy() {
        Map<String, String> ma = new HashMap<String, String>();
        ma.put("01", "zhang1");
        ma.put("02", "zhang2");
        ma.put("03", "zhang3");
        ma.put("04", "zhang4");

        Set<String> key = ma.keySet();
        for (Iterator it = key.iterator(); it.hasNext(); ) {
            Object st = it.next();
            System.out.println("key: " + st);

            System.out.println("value: " + ma.get(st));
        }
        Collection<String> va=new ArrayList<>();
        va=ma.values();
        for (String each:va){
            System.out.println(each);
        }
    }

    public static void entrySetStudy() {
        Map<String, String> ma = new HashMap<String, String>();
        ma.put("01", "zhang1");
        ma.put("02", "zhang2");
        ma.put("03", "zhang3");
        ma.put("04", "zhang4");
        Set<Map.Entry<String, String>> it = ma.entrySet();
        for (Iterator<Map.Entry<String, String>>i1 = it.iterator(); i1.hasNext(); ) {
//            Object obj=i1.next();
//            Map.Entry<String,String> a=(Map.Entry) obj;
            Map.Entry<String, String> a = i1.next();
            //直接从关系中获取key和value
            System.out.println("key: " + a.getKey());
            System.out.println("value " + a.getValue());
        }
    }
}
