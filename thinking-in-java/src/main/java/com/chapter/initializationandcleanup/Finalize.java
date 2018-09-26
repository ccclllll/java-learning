package com.chapter.initializationandcleanup;

public class Finalize {

    @Override
    protected void finalize(){
        System.out.println("finalize be called");
    }
}
