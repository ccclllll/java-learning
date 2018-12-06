package com.chapter.typeinfo;

import org.junit.jupiter.api.Test;

import javax.jws.Oneway;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;


public class TypeInfoTest {

    Logger logger = Logger.getLogger("TypeInfo");

    interface A {
    }

    class B {
        public void tt() {
            logger.info("tt executing");
        }
    }

    class C {
        private String name;
        private int age;

        public C(){}
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "D{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    class D {
        private String name;
        private int age;

        public D(){}
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "D{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    @Test
    public void testClassLoader() {
        try {
            Class.forName("com.chapter.typeinfo.Class1");
            System.out.println(Class.forName("com.chapter.typeinfo.Class1").getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassObject() throws Exception {
        B b = new B();
        Class cc = b.getClass();
        logger.info(cc.getName());
        logger.info(cc.getSimpleName());

        for (Method method : cc.getMethods()) {
            if (method.getName().equals("tt")) {
                method.invoke(b);
            }
        }
    }


    /**
     * can be used to copy properties with getter and setter methods
     * @param target
     * @param source
     * @return
     * @throws Exception
     */
    public static Object copyProperty(Object target, Object source) throws Exception {
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();

        for (Field field : sourceClass.getDeclaredFields()) {
            if (targetClass.getDeclaredField(field.getName()) == null || field.getName().equals("this$0")) { continue; }
            String methodSuffix = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            Method method = targetClass.getDeclaredMethod("set" + methodSuffix, field.getType());
            method.invoke(target, sourceClass.getDeclaredMethod("get"+methodSuffix).invoke(source));
        }
        return target;
    }

    public static Object copyProperty1(Object target, Object source) throws Exception {
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();

        for (Field field : sourceClass.getDeclaredFields()) {
            field.setAccessible(true);
            Field targetField = targetClass.getDeclaredField(field.getName());
            targetField.setAccessible(true);
            if(targetField!=null&&targetField.getType().getCanonicalName().equals(field.getType().getCanonicalName())){
                targetField.set(target,field.get(source));
            }
        }
        return target;
    }

    public static Object createInnerClassObject(Object o) throws Exception{

        for(Class cc : o.getClass().getDeclaredClasses()){
            int mod = cc.getModifiers();
            String modifier = Modifier.toString(mod);

            if(!modifier.contains("static")){
                try {
                    Object oo = cc.getConstructors()[0].newInstance(o);
                    System.out.println(oo.getClass().getSimpleName());
                }catch (Exception e){
                    try{
                        Object oo = cc.getDeclaredConstructors()[0].newInstance(o);
                        System.out.println(oo.getClass().getSimpleName());
                    }catch (Exception ee){
                        throw ee;
                    }
                }

            }

        }
        return o;
    }

    @Test
    public void testCopy() throws Exception {
        C c = new C();
        D d = new D();
        c.setName("zs");
        c.setAge(10);
        copyProperty1(d, c);
        System.out.println(d.toString());
    }

    @Test
    public void testCreateInner()throws Exception{
        TypeInfoTest typeInfoTest = new TypeInfoTest();
        createInnerClassObject(typeInfoTest);
    }

    static class ATest {
        String testStr;

        public void settestStr(java.lang.String str) {
            this.testStr = str;
        }
    }


    public static void main(String[] args) throws Exception{
        String[] param = new String[]{"testStr"}; //这个是要设置的字符串
        ATest a = new ATest();
        java.lang.reflect.Method m = (ATest.class).getMethod("settestStr", new Class[]{String.class});
        Object b = m.invoke(a, param);
        System.out.println(a.testStr);
    }
}

