package com.chapter.initializationandcleanup;
class Mug{
    Mug(String mark){
        System.out.println("mark = [" + mark + "]");
    }
}
public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug("hhh");
        mug2 = new Mug("xixi");
    }

    public static void main(String[] args) {
        Mugs mugs = new Mugs();
    }
}
