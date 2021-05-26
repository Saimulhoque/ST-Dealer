package com.forbitbd.stdealers.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.forbitbd.stdealers.MainActivity;
import com.forbitbd.stdealers.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GoogleSignInClient client;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();
    }

    public void setupToolbar(int id){
        toolbar = findViewById(id);
        setSupportActionBar(toolbar);

    }

    public GoogleSignInClient getGoogleApiClient() {
        return client;
    }

    public FirebaseAuth getAuth(){
        return mAuth;
    }

    public void signOut(){
        client.signOut();
        mAuth.signOut();
    }
}
