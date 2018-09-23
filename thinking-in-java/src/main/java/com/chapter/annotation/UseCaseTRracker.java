package com.chapter.annotation;

import com.chapter.annotation.annotations.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UseCaseTRracker {
    public static void trackerUseCase(List<Integer> useCases,Class<?> clazz){
        for(Method method:clazz.getDeclaredMethods()){
            UseCase useCase = method.getAnnotation(UseCase.class);
            if(useCase!=null){
                System.out.println("Found UseCase"+useCase.id()+" "+useCase.description());
            }
        }
    }

    public static void main(String args[]){
        List<Integer> useCases = new ArrayList<Integer>();
        trackerUseCase(useCases,PasswordUtil.class);
    }
}
