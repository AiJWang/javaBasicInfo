package Study.SomeClassTest;

/**
 * @ClassName SystemClassStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午7:04
 * @Version 1.0
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * System: 描述系统信息，类中的方法和属性都是静态的
 * out：标准输出到控制台
 * Properties getProperties: 获取系统属性信息
 *
 * runTime: 该类中未提供构造函数，无法建立对象 通过getRunTime获取对象
 *
 * Date:日期
 * */
public class SystemClassStudy {
    public static void main(String[] args) {
        //系统操作
        //systemTest();

        //日期操作
        //dateTest();

        //日历
        calendarTest();

    }
    public static void systemTest(){
        Properties properties=System.getProperties();
        for (Object obj:properties.keySet()){
            String value=(String) properties.get(obj);
            System.out.println(obj+": "+value);
        }
    }

    public static void runTimeTest() throws Exception{
        Runtime rt=Runtime.getRuntime();
        //可以执行命令 比如启动别的应用，qq之类的
        Process p= rt.exec("");
        //杀进程
        p.destroy();
    }

    public static void dateTest(){
        Date d=new Date();
        System.out.println(d);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss SSS w W F K a h z Z");

        String nowTime=sd.format(d);
        System.out.println(nowTime);
    }

    public static void calendarTest(){
        Calendar ca=Calendar.getInstance();
        calendarPrint(ca);
        System.out.println(ca.getTime());
        System.out.println("-------");
        //修改年月日
        //年份+1
        ca.add(Calendar.YEAR,1);
        calendarPrint(ca);
        //月份+2
        ca.add(Calendar.MONTH,2);
        calendarPrint(ca);
        //日期-2
        ca.add(Calendar.DAY_OF_MONTH,-2);
        calendarPrint(ca);

        ca.set(Calendar.MONTH,9);
        calendarPrint(ca);

    }

    public static void calendarPrint(Calendar ca){
        System.out.println(ca.get(Calendar.YEAR)+"-"+ca.get(Calendar.MONTH)+"-"+
                ca.get(Calendar.DAY_OF_MONTH));
    }

}
