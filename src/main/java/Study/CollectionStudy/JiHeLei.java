package Study.CollectionStudy;

/**
 * @ClassName JiHeLei
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/2 下午3:02
 * @Version 1.0
 */

/**
 * 集合类：
 * 集合类是用来存放某类对象的。集合类有一个共同特点，就是它们只容纳对象
 * Java中的集合类可以分为两大类：一类是实现Collection接口；另一类是实现Map接口。
 * Collection有两个重要的子接口List和Set
 */
public class JiHeLei {
    public static void main(String[] args) {
        String a="https://tracklog.58.com/m/click/empty.js.gif?site_name=58&tag=performance&from=lbg_direct_buluoshow&trackURL=%7B%27tt%27%3A0%2C%27pid%27%3A1038%2C%27source%27%3A0%2C%27type%27%3A14%2C%27local%27%3A110000000000%2C%27mac%27%3A%2702%27%2C%27osv%27%3A%2713.4.1%27%2C%27pos%27%3A1%2C%27crc%27%3A%27e62806626cfcff8a5b63dd7355f1757d%27%2C%27appv%27%3A%2710.11.1%27%2C%27client%27%3A12%2C%27mf%27%3A%27Apple%27%2C%27model%27%3A%27iPhone+XR_iOS+13.4.1%27%2C%27id%27%3A335%2C%27bundle%27%3A%27com.taofang.iphone%27%2C%27lat%27%3A39.99347%2C%27prcid%27%3A0%2C%27identify%27%3A%271F6C7299-E48E-4720-AD36-31F0DBE74B0F%27%2C%27os%27%3A%27ios%27%2C%27lng%27%3A116.51225%2C%27ip%27%3A%2736.110.58.26%27%2C%27prid%27%3A102%2C%27gp%27%3A%27lbg_direct_buluoclick%27%2C%27cs%27%3A%27%27%2C%27ct%27%3A%27WIFI%27%2C%27as%27%3A0%2C%27carrier%27%3A0%2C%27at%27%3A0%2C%27t%27%3A1614927839203%2C%27tp%27%3A%27lbg_direct_buluoshow%27%2C%27pn%27%3A0%2C%27did%27%3A%27b7337fffa29172583f6db6e7d6494a1fcc1da081%27%7D&referrer=&rand=1614927839203";
        String planXShowInter="https://facai.58.com/buluoCallback/1?sign=KHNXfz_pn7EP2AnwzuzwaaveuFlyaqlLVjUwFuhjzKEYCMl3rncync68SFU96Ih-";
        String PlanxShowReal="https://facai.58.com/buluoCallback/2?sign=KHNXfz_pn7EP2AnwzuzwaaveuFlyaqlLVjUwFuhjzKF18duxhadTJVebsz_f5BSn";
        System.out.println(planXShowInter.equals(PlanxShowReal));
    }
}
