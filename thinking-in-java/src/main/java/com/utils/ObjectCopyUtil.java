package com.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectCopyUtil {
    /**
     * can be used to copy properties with getter and setter methods
     * @param target
     * @param source
     * @return
     * @throws Exception
     */
    public static Object _copyProperty(Object target, Object source) throws Exception {
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

    /**
     *
     * @param target 目标对象
     * @param source 源对象
     * @return target
     * @throws NoSuchFieldException & IllegalAccessException
     */
    public static Object copyProperty(Object target, Object source) throws NoSuchFieldException,IllegalAccessException {
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
}
