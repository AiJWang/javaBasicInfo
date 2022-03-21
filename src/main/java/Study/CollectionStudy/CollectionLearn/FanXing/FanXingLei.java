package Study.CollectionStudy.CollectionLearn.FanXing;

/**
 * @ClassName FanXingLei
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/7 下午12:14
 * @Version 1.0
 */
//定义一个泛型工具类，当类中要操作的引用数据类型不确定的时候用的
public class FanXingLei<QQ> {
    private QQ q;

    public void setQ(QQ q) {
        this.q = q;
    }

    public QQ getQ() {
        return this.q;
    }

    public void show(QQ q) {
        System.out.println(q);
    }
}
