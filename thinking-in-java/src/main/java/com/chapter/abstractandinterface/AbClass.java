package com.chapter.abstractandinterface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

abstract class AbstractClass {
    void fun() {
        System.out.println("AbClass fun called");
    }
    abstract void fun(String name);
}

class A extends AbstractClass {
    static  A a = new A();
    A() {
        System.out.println("A con");
    }

    void fun(String name) {
        this.fun();
    }

    protected static void f(){}
    private static String ff(){
        A.f();
        return null;
    }
}

class B extends AbstractClass{
    static {

    }

    {

    }
    B(String index) {
        System.out.println("B con"+index);
    }

    void fun(String name) {

    }
}

class RandomReadable implements Readable{

    private int count;

    public final static char[] CHARS = "ABCDEFG".toCharArray();
    public static Random random = new Random(40);
    public RandomReadable(int count){
        this.count = count;
    }

    public static final String getString(){
        return CHARS[random.nextInt(CHARS.length)]+" ";
    }
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0)
            return -1;
        String s = getString();
        cb.append(s);
        return s.length();
    }
}

public class AbClass extends A{
    static B b = new B("1");

    static {
        B b = new B("2");
    }

    AbClass(){
        A a = new A();
    }
    public static void main(String[] args) {
/*        AbClass abClass = new AbClass();
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void fun() {
                super.fun();
            }

            void fun(String name) {

            }
        };*/
        Scanner scanner = new Scanner(new RandomReadable(10));

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }

    }
}

interface CanFight {
    String NAME = "ZS"; // public static final
    String fight();
}
interface CanSwim {
    void swim();
}
interface CanFly {
    void fly();
    String fight();
}
class ActionCharacter {
    PII pii = new PII();
    static public class A{
        static String a = "";
    }

    private interface PI{
        A a();
    }
    static public interface B{
        String NAME = "ZS";
    }

    public class PII implements PI{

        public A a() {
            return null;
        }
    }

    private class AA{

    }

    public  AA aA(){
        return new AA();
    }


    /** PI是私有的接口，这个方法只能在本类使用**/
    PI pii(){

        return null;
    }

    void testPii(){


        new CanFight(){

            public String fight() {
                return null;
            }
        };
    }

}

final class CC{

}
class Hero
        implements CanSwim, CanFly, CanFight{



    public void swim() {}
    public void fly() {}

    ActionCharacter actionCharacter = new ActionCharacter();
    public String fight() {

        System.out.println(CanFight.NAME);

        actionCharacter.aA();
        return null;
    }


}
