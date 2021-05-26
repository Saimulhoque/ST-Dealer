package com.forbitbd.stdealers.utils;

import android.util.Patterns;

public class MyUtil {

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
