package com.example.usersservice.Util;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern pattern  = Pattern.compile(emailPattern);

    public static boolean isValid(String email){
        return pattern.matcher(email).matches();
    }


}
