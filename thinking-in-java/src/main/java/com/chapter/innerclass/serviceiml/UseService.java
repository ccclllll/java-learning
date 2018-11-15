package com.chapter.innerclass.serviceiml;

import com.chapter.innerclass.service.MyService;

public class UseService {
    private static String s = "12";
    protected class UserService implements MyService {
        private  String name = "1212";
        public void doService() {
            System.out.println("user service do");
        }
    }

    public String getInnerName(){
        UserService userService = new UserService();
        return userService.name;
    }


}
