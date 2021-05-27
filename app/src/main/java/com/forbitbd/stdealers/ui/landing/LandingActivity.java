package com.forbitbd.stdealers.ui.landing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.WelcomeFragment;
import com.forbitbd.stdealers.WelcomeListener;
import com.forbitbd.stdealers.ui.login.LoginActivity;
import com.forbitbd.stdealers.ui.main.MainActivity;
import com.forbitbd.stdealers.utils.AppPreference;
import com.forbitbd.stdealers.utils.BaseActivity;

public class LandingActivity extends BaseActivity implements LandingContract.View, WelcomeListener {

    LandingPresenter mPresenter;
//    Handler handler = new Handler();
//    Runnable runnable;
//    int delay = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mPresenter = new LandingPresenter(this);
        mPresenter.checkdealer();
    }
//
//    @Override
//    protected void onResume() {
//        handler.postDelayed(runnable = new Runnable() {
//            @Override
//            public void run() {
//                handler.postDelayed(runnable,delay);
//                mPresenter.checkdealer();
//            }
//        },delay);
//
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        handler.removeCallbacks(runnable);
//        super.onPause();
//    }

    @Override
    public void Startlogin() {
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void StartMain() {
            if (AppPreference.getInstance(this).getDealer().getIs_active()) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                WelcomeFragment welcome_fragment = new WelcomeFragment();
                welcome_fragment.setCancelable(false);
                welcome_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
        }
    }
}
