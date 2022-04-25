package MsbStudy.HighLevel;

/**
 * 八种基本数据类型
 * short    Short    --》number-->Object
 * int      Integer  --》number-->Object
 * long     Long     --》number-->Object
 * float    Float    --》number-->Object
 * double   Double   --》number-->Object
 * byte     Byte     --》number-->Object
 * boolean  Boolean  -->Object
 * char     Character -->Object

 * */
public class Jibenshujuleixing {
    public static void main(String[] args) {
        //int 取值范围
        Integer max=Integer.MAX_VALUE;
        Integer min=Integer.MIN_VALUE;
        System.out.println(max);
        System.out.println(min);
        //自动装箱，自动拆箱
        Integer a=12;
        System.out.println(a);
    }
}
