package com.forbitbd.stdealers.ui.profile;

public class ProfilePresenter implements ProfileContract.Presenter{

    private ProfileContract.View mView;

    public ProfilePresenter(ProfileContract.View mView) {
        this.mView = mView;
    }

}
