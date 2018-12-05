package com.chapter.typeinfo;

import org.junit.jupiter.api.Test;

public class TypeInfoTest2 {
    class A{
        private int age;
    }
    class B extends A{

    }

    @Test
    public void testCast(){
        A a = new B();
        Class<B> bType = B.class;
        B b = bType.cast(a);

        B bb = new B();

        A aa = A.class.cast(bb);




    }
}
