package Study.JiBenShuJuLeiXingDuiXiangBaoZhuang;

/**
 * @ClassName JiBenShuJuLeiXingDuiXiangBaoZhuang
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/2 下午2:01
 * @Version 1.0
 */

/**
 * 基本数据类型对象封装：
 * int：Integer
 * long：Long
 * double：Double
 * float：Float
 * char：Character
 * byte：Byte
 * short：short
 * boolean：Boolean
 * <p>
 * 主要的作用就是和字符串互相转换
 * <p>
 * 转换为字符串：Integer.toString(34)
 * <p>
 * 字符串转换为基本数据类型：
 * Xxx a= Xxx.parseXxx(str)
 * int num=Integer.parseInt("123");
 * <p>
 * 其它进制 转换成10进制
 * int x=Integer.parseInt(str,jinzhi)
 * <p>
 * 10进制转化为其它进制
 * Integer.toBinaryString(8); 转化为二进制
 * Integer.toHexString:转化为8进制
 * Integer.toOctalString:转化为16进制
 **/
public class JiBenShuJuLeiXingDuiXiangBaoZhuang {
    public static void main(String[] args) {
        int num = Integer.parseInt("123");
        Integer h = 5;
        System.out.println("num");
        System.out.println("int value" + h.intValue());
        //将二进制的数据转化为10进制
        int x = Integer.parseInt("110001", 2);
        System.out.println(x);
        //16进制的9AC转化为10进制
        int y = Integer.parseInt("9AC", 16);
        System.out.println(y);
        //十进制转化为2进制
        String z = Integer.toBinaryString(8);
        System.out.println(z);
        //十进制转换为16进制
        String a = Integer.toHexString(10);
        System.out.println(a);
        //十进制转换为8进制
        String b = Integer.toOctalString(17);
        System.out.println(b);
    }
}
