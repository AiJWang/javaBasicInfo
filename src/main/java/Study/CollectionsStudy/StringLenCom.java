package Study.CollectionsStudy;

import java.util.Comparator;

/**
 * @ClassName StringLenCom
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午4:20
 * @Version 1.0
 */
public class StringLenCom implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length()>o2.length())
            return 1;
        else if (o1.length()<o2.length())
            return -1;

        return 0;
    }
}
