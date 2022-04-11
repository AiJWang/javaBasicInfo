package MsbStudy.BasicInfo;

/**
 * 内部类:成员内部类（静态，非静态），局部内部类（方法内，块内，构造器内）
 *
 * 成员内部类 包含：
 *      属性，方法，构造器等，还可以有内部类
 *      跟正常类一样，可以继承，之类的
 *      内部类可以使用外部类成员变量及方法
 *      外部类访问内部类，需要创建内部类对象进行调用
 *      内部类和外部类属性重名时是使用方式
 * */
public class NeiBuLei {
    String name="NeiBuLeiName";
    int age;
    //成员内部类，非静态
    class B{
        String name="B name";
        void Btest(){
            String name="cTest name";
            System.out.println("tshi is B class metod ");
            eat();
            age=10;
            //调用外部变量
            System.out.println("调用方法中变量，直接用就行了："+name);
            //调用内部类属性、
            System.out.println("调用C的属性name： "+this.name);
            //调用外部属性
            System.out.println("调用最外面的属性："+NeiBuLei.this.name);
        }
    }
    //成员内部类  静态
    static class C{
        String name;
        void cTest(){
            System.out.println("this is c classmethod");
        }
    }

    public void eat(){
        System.out.println("eat all......");
        C c=new C();
        c.cTest();
        {
            System.out.println("这是局部代码块，普通块");
        }
    }
    static {
        System.out.println("这是一个静态块，最先加载");
    }
    {
        System.out.println("这是构造块，比构造器还早执行");
        //局部内部类
        class A{

        }
    }

}
//局部内部类
class JuBuNeiBuLei{
    public void eat(){
        int num=10;
        class A{
            public void a(){
                //num=100; 被局部内部类访问到的外部变量必须是final的，即使没写，也省略了
                System.out.println("调用外部num");
            }
        }
    }
    public Comparable a(){
        //如果B只是用一次，就不用单独创建了，在内部使用就行了，这就是匿名内部类开头，具体见下方
        class B implements Comparable {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        return new B();
    }
    public Comparable b(){
        //匿名内部类，返回的是匿名内部类的对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}



//创建内部类对象
class TestMain{
    public static void main(String[] args) {
        //创建外部类对象
        NeiBuLei n=new NeiBuLei();
        //创建静态内部类对象
        NeiBuLei.C c=new NeiBuLei.C();
        //创建非静态内部类对象
        NeiBuLei.B b=new NeiBuLei().new B();
    }
}
