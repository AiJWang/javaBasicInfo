package MsbStudy;

/**
 * throw 和 throws区别
 *① 位置不同
 *      throw在方法内
 *      throws 在方法命名处
 *②对接的内容不同
 *      throw：new RuntimeException()  //抛出异常对象
 *      throws: Exception  接的是一场名称、
 *
 *③作用不同
 *      throw:异常出现的源头，制造异常
 *      throws：方法声明出告诉调用这此方法可能的异常
 *
 * */
public class TryCatchStudy {
    //除法
    public static void test(int a,int b) throws Exception {
        if (b==0){
            throw new Exception();
        }else {
            System.out.println(a/b);
        }
    }
}
