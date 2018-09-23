package com.chapter.chapter3;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.Calendar;
import java.util.Date;

public class Chapter3Test {
    @Test
    public void testAuto(){
        int i = 1;
        int j= 1;
        System.out.println("i++ is  " + i++); // 先拿到值 输出1
        System.out.println("++j is " + ++j); // 先执行运算 后拿到值 输出2
        float f1 = 1F;
        long l1 = 1L;
        int c = 0xffff; // 0x表示十六进制
        System.out.println(f1+":"+l1+":"+c);
        int i1 = 1;
        int i2 = 0;
        System.out.println(1&0); // 按位与 0
        System.out.println(1^0);// 按为或 1
        System.out.println(1|0);// 异或 1
        i1&=i2; // i1=i1&i2
        System.out.println(i1); // 0

        double d2 = 12.53433453536; // 有效数字16位
        float f2 = (float) d2; // 有效数字7位 包括小数点在内
        int i3 = (int) d2;
        System.out.println(i3); // 12 精度流失
        System.out.println(f2); // 12.534334

    }

    @Test
    public void testDate(){
   /*     Date date = new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println("现在时间是："+new Date());
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        String year=String.valueOf(calendar.get(Calendar.YEAR));
        String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String week=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);
        System.out.println("现在时间是："+year+"-"+month+"-"+day+"日，周"+week);
        long year2009=calendar.getTimeInMillis();
        calendar.set(1989,9,26);//这里与真实的月份之间相差1
        long year1989=calendar.getTimeInMillis();
        long days=(year2009-year1989)/(1000*60*60*24);
        System.out.println("今天和1989年10月26日相隔"+days+"天，"+"也就是说我在这个美丽的星球上已经幸福的生活了"+days+"天。");

*/
        System.out.println(handleWeekDay(1));
    }

    public String handleWeekDay(int num){

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println("现在时间是："+new Date());
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); //每周的第一天
        calendar.roll(Calendar.DAY_OF_YEAR, num);
        String year=String.valueOf(calendar.get(Calendar.YEAR));
        String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String week=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);
        System.out.println("现在时间是："+year+"-"+month+"-"+day+"日，周"+week);
        return year+"-"+month+"-"+day +week;
    }
}
