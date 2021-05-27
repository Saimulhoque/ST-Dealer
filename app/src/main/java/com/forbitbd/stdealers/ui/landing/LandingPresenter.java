package com.forbitbd.stdealers.ui.landing;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingPresenter implements LandingContract.Presenter{

    private LandingContract.View mView;
    private FirebaseUser mCurrentUser;

    public LandingPresenter(LandingContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void checkdealer() {
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mCurrentUser == null) {
            mView.Startlogin();
        } else {

            mView.StartMain();
        }
    }
}
