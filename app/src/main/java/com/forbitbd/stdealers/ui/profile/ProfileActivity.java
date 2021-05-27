package com.forbitbd.stdealers.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.models.Dealer;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.textfield.TextInputEditText;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View{

    private ProfilePresenter mPresenter;
    private TextInputEditText name,email, org, phone, address;
    private CircularImageView image;
    private Dealer dealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mPresenter = new ProfilePresenter(this);
        name = findViewById(R.id.username);
        email = findViewById(R.id.useremail);
        org = findViewById(R.id.org_name);
        phone = findViewById(R.id.userphone);
        address = findViewById(R.id.useraddress);
        image = findViewById(R.id.userphoto);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        name.setText(account.getDisplayName());
        email.setText(account.getEmail());
        Picasso.with(this).load(account.getPhotoUrl()).into(image);
    }
}