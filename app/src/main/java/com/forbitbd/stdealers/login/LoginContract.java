package com.forbitbd.stdealers.login;

public interface LoginContract {

    interface Prensenter{
        void google_click();

    }

    interface View{
        void googleSignIn();
        void startMainActivity();
    }
}
