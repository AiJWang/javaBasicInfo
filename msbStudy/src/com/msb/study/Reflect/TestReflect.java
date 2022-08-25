package com.msb.study.Reflect;

import java.lang.reflect.Method;

/**
 * 反射案例：
 * 比如美团的支付，美团会对外提供一个api，合作厂商会实现这个api，最后美团调用判断就好了
 * */
public class TestReflect {

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) throws Exception{
        //模拟用户输入
        String yonghuxuanze="微信";

        if (yonghuxuanze.equals("微信")){
            pay(new WeChat());
        }else if (yonghuxuanze.equals("支付宝")){
            pay(new ZhiFuBao());
        }
        /**
         * 当前虽然利用多态特性，简化代码了，但是上面的if入口还是要增加的，因此引入反射
         * */
        String user="com.msb.study.Reflect.WeChat";
        Class cls=Class.forName(user);
        Object o=cls.newInstance();
        Method m=cls.getMethod("payOnline");
        m.invoke(o);
    }
    public static void pay(MeiTuan meiTuan){
        meiTuan.payOnline();
    }
}
