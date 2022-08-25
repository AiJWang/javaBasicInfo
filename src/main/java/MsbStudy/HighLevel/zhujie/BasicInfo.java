package MsbStudy.HighLevel.zhujie;

public class BasicInfo extends ZhuJieFather {
    /**
     * override :子类对父类重写
     * deprecate: 被这个注解修饰的方法，是废弃/过期的方法
     * */
    public static void main(String[] args) {

    }

    @Override
    public String eat(){
        return "son eat";
    }

    @Deprecated
    public String smile(){
        return "smile";
    }
}
