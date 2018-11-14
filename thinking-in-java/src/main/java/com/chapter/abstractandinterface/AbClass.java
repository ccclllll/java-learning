package com.chapter.abstractandinterface;

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


public class AbClass extends A{
    static B b = new B("1");

    static {
        B b = new B("2");
    }

    AbClass(){
        A a = new A();
    }
    public static void main(String[] args) {
        AbClass abClass = new AbClass();
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void fun() {
                super.fun();
            }

            void fun(String name) {

            }
        };
    }
}

interface CanFight {
    void fight();
}
interface CanSwim {
    void swim();
}
interface CanFly extends CanFight {
    void fly();
}
class ActionCharacter {

}
class Hero extends ActionCharacter
        implements CanSwim, CanFly {


    public void swim() {}
    public void fly() {}

    public void fight() {

    }
}