package com.chapter.annotation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//this annotation is use to describe where can use the annotation
@Target(ElementType.METHOD)
// 哪一个级别可以用 RUNTIME SOURCE CLASS 
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    String description() default "no description";
}
