package Java8Time;

import java.time.*;

/**
 * java8 新时间,不可变对象
 * 人读的：
 * localDate：日期
 * localTime：时间
 * localDateTime：人读的，本地的时间和日期
 * 机器读的时间戳
 * instant：时间戳，自1970-1-1 00:00:00 至现在的时间戳
 *
 * duration:时间间隔，
 * period：日期间隔
 * */
public class TimeBasicInfo {
    public static void main(String[] args) throws InterruptedException {
        testLocalDateTime();
        System.out.println("--------------------");
        testInstant();
        System.out.println("--------------------");
        testDuration();
    }
    public static void testLocalDateTime(){
        LocalDateTime l=LocalDateTime.now();
        System.out.println(l);

        LocalDateTime l2=LocalDateTime.of(2021,1,1,1,1,1);
        System.out.println(l2);

        //加年
        LocalDateTime l3=l2.plusYears(2);
        System.out.println(l3);
        //减月

        LocalDateTime l4=l2.minusMonths(1);
        System.out.println(l4);

        System.out.println(l4.getDayOfWeek());

    }

    public static void testInstant(){
        Instant in1=Instant.now();//默认为UTC时间，不是东八区
        System.out.println(in1);
        //增加偏移量
        OffsetDateTime of=LocalDateTime.now().atOffset(ZoneOffset.ofHours(8));//差8个时区，所以偏移量为0
        System.out.println(of);
        //时间戳
        System.out.println(in1.toEpochMilli());

        //计算 1970+1秒
        System.out.println(Instant.ofEpochSecond(1));

    }

    public static void testDuration() throws InterruptedException {

        //两个时间间隔毫秒
        Instant in=Instant.now();
        Thread.sleep(1000);
        Instant in1=Instant.now();
        Duration d=Duration.between(in,in1);
        System.out.println(d.toMillis());

        LocalDate l=LocalDate.now();
        LocalDate l1=LocalDate.of(2022,3,19);
        Period p=Period.between(l,l1);
        System.out.println(p.getMonths());

    }
}
