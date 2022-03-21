package Study.LambdaStudy;

/**
 * @ClassName BasicInfo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/13 下午6:54
 * @Version 1.0
 */
/**
 * 正则表达式：专门用于操作字符串
 *
 * 具体操作：
 * 1、匹配：String的 matches方法
 * 2、切割：String的 spit方法
 * 3、替换：replaceAll()
 * 4、获取：重点！！！
 *        将字符串中符合规则的子串取出
 *        操作步骤：
 *            1、将正则表达式封装成对象
 *            2、让正则表达式和目标字符串关联
 *            3、关联后，获取正则匹配引擎
 *            4、通过引擎对符合规则的子串进行操作，比如取出
 *
 * 用那个方法呢：
 * 1、如果只想知道字符串是对还是错，用匹配
 * 2、将已有的字符串变成另一个，替换
 * 3、按照自定义的方式，将字符串变成多个字符串，获取规则以外的子串，切割
 * 4、按到符合需求的子字符串，符合获取规则，获取
 * */
public class BasicInfo {
    public static void main(String[] args) {
        String a="https://wx018tzbl.58.com/tzbl/noise/index.shtml";
        if (a.matches("wx\\d{3}tzbl.58.com/tzbl/noise/index.shtml"))
            System.out.println("匹配");


        System.out.println((char) '0');
        //匹配演示
        checkQQ();
        //正则的方法
        checkQQ1();

        //切割演示
        splitDemo();


        //替换demo
        //将str中数字替换为#
        String str="jdhfoui348ds5483jdjldasjhf23f0fjnr3";
        replaceDemo(str,"\\d{3,}","#");//超过连续3个数字，替换为#

        String str1="ddjbswwmwwwldmm";//将叠词替换为&
        replaceDemo(str1,"(.)\\1+","&");

        //将叠词都变为1个词,$1 获取的是前面组(.)中的值 zzzz-->z
        replaceDemo(str1,"(.)\\1+","$1");
    }

    //5-15位，0不能开头，只能是数字
    public static void checkQQ(){
        String qq="12345gg";
        int len=qq.length();

        if (len>=5&&len<=15){
            if (!qq.startsWith("0")){
                try {
                    long l=Long.parseLong(qq);
                    System.out.println("没毛病");

                }catch (Exception e)
                {
                    System.out.println("有非数字字符");
                }
            }
        }
        else {
            System.out.println("长度不匹配");
        }
    }

    public static void checkQQ1(){
        String qq="1234we";
        String regx="[1-9][0-9]{4,14}";

        boolean b=qq.matches(regx);

        if (b){
            System.out.println("没毛病");
        }
        else
            System.out.println("有问题");

    }

    public static void splitDemo(){
        String str="zhangsan  lisi  wuangwu";

        String reg=" +";//按照多个空格切割

        String arr[]=str.split(reg);
        for (String s:arr){
            System.out.println(s);
        }

        //按照\\切割
        str="c:\\abc\\a";
        reg="\\\\";
        arr=str.split(reg);
        for (String s:arr){
            System.out.println(s);
        }

        //叠词切割
        str="erkktyuuizzpoooq";
        reg="(.)\\1+";//第一位是任意字符，第二位跟第一位一样，(.)相当于一个组
        arr=str.split(reg);
        for (String s:arr){
            System.out.println(s);
        }
    }

    //替换demo
    public static void replaceDemo(String str,String reg,String newS){
        str=str.replaceAll(reg,newS);
        System.out.println(str);
    }
}
