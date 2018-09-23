package com.chapter.annotation;

import com.chapter.annotation.annotations.UseCase;

public class PasswordUtil {
    @UseCase(id = 47, description = "Password must contains at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
}
