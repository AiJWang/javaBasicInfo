package MsbStudy.HighLevel;

import java.util.Random;

public class RandomStudy {
    public static void main(String[] args) {
        //带参构造器,每次运行生成的随机数都是固定的
        Random d=new Random(12);
        System.out.println(d.nextInt());
        //空参构造器,实际底层掉的还是代餐构造器，只是seed值每次都不固定
        Random random=new Random();
        System.out.println(random.nextInt(100));//随机0-100之间的随机数
        System.out.println(random.nextInt());
    }
}
