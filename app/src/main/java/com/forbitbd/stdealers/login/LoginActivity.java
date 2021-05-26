package com.forbitbd.stdealers.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.forbitbd.stdealers.MainActivity;
import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.utils.BaseActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity implements View.OnClickListener, com.forbitbd.stdealers.login.LoginContract.View{

    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 9001;
    private LoginPresenter mpresenter;
    private SignInButton signInButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mpresenter = new LoginPresenter(this);
        signInButton = findViewById(R.id.google_sign_in);
        signInButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startMainActivity();
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                mpresenter.startAutentication(result);
                break;
        }
    }

    @Override
    public void googleSignIn() {
        Intent signInIntent = getGoogleApiClient().getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onClick(View view) {
        googleSignIn();
    }

    @Override
    public void startMainActivity() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}