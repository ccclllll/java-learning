package com.chapter.initializationandcleanup;

import org.junit.jupiter.api.Test;

public class ChapterTest {
   @Test
    public void testStatic(){
/*       StaticTest.InnerStaticClass.f();*/
       StaticTest staticTest = new StaticTest();
       StaticTest.InnerStaticClass innerStaticClass = staticTest.new InnerStaticClass();
       innerStaticClass.f();
   }
   @Test
    public void testSay(){
       String s[] = new String[]{"1","2"}; // 创建引用并进行初始化，s是一个数组，并且为String类型
       String[] s1 = new String[5]; // 必须给予数组长度 s1是一个String数组类型。
       s1[0] = "1";
       StaticTest.say(s);
   }
   Object object;
}
