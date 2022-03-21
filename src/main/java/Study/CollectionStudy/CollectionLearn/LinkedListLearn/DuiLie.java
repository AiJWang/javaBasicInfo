package Study.CollectionStudy.CollectionLearn.LinkedListLearn;

import java.util.LinkedList;

/**
 * @ClassName DuiLie
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/3 下午8:01
 * @Version 1.0
 */
public class DuiLie {
    LinkedList linkedList;

    DuiLie() {
        linkedList = new LinkedList();
    }

    public void myAdd(Object obj) {
        linkedList.addFirst(obj);
    }

    public Object myGet() {
        return linkedList.pollLast();
    }

    public Boolean isNull() {
        return linkedList.isEmpty();
    }
}
