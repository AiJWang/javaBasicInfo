package MsbStudy.HighLevel;
/**
 * Math常用方法
 *
 * */
public class MathStudy {
    public static void main(String[] args) {
        //PI
        System.out.println(Math.PI);
        //随机数[0.0,1.0) 左闭右开
        System.out.println(Math.random());
        System.out.println("绝对值:"+Math.abs(-100));
        System.out.println("向上取值："+Math.ceil(9.1));
        System.out.println("向下取值："+Math.floor(9.5));
        System.out.println("四舍五入："+Math.round(3.3));
    }
}
