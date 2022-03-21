package Study.CollectionStudy.CollectionLearn.LinkedListLearn;

/**
 * @ClassName LinkList
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/3 下午7:49
 * @Version 1.0
 * <p>
 * addFirst():首部添加
 * addLast()：尾部添加
 * <p>
 * getFirst（）：获取首部
 * getLast（）：获取尾部，若无元素，抛异常
 * <p>
 * removeFirst（）：获取首部并删除，若无元素，抛异常
 * removeLast（）：同上
 * <p>
 * 所以：peekFirst／pickLast 取代getFirst
 * pollFirst／pollLast 取代removeFirst
 * <p>
 * addFirst():首部添加
 * addLast()：尾部添加
 * <p>
 * getFirst（）：获取首部
 * getLast（）：获取尾部，若无元素，抛异常
 * <p>
 * removeFirst（）：获取首部并删除，若无元素，抛异常
 * removeLast（）：同上
 * <p>
 * 所以：peekFirst／pickLast 取代getFirst
 * pollFirst／pollLast 取代removeFirst
 */
/**
 * addFirst():首部添加
 * addLast()：尾部添加
 *
 * getFirst（）：获取首部
 * getLast（）：获取尾部，若无元素，抛异常
 *
 * removeFirst（）：获取首部并删除，若无元素，抛异常
 * removeLast（）：同上
 *
 * 所以：peekFirst／pickLast 取代getFirst
 *      pollFirst／pollLast 取代removeFirst
 * */

/**
 * LinkedList模拟堆栈和队列
 * 堆栈：先进后出，如杯子
 * 队列：先进先出，管子
 * */
public class LinkList {
    public static void main(String[] args) {

        DuiLie duiLie = new DuiLie();
        duiLie.myAdd("java01");
        duiLie.myAdd("java02");
        duiLie.myAdd("java03");
        duiLie.myAdd("java04");

        sop(duiLie);

        while (!duiLie.isNull()) {
            sop(duiLie.myGet());
        }
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
