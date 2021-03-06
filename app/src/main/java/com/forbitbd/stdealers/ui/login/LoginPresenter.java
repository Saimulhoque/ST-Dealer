package com.forbitbd.stdealers.ui.login;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.forbitbd.stdealers.api.ApiClient;
import com.forbitbd.stdealers.api.ServiceGenerator;
import com.forbitbd.stdealers.models.Dealer;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends AppCompatActivity implements com.forbitbd.stdealers.login.LoginContract.Prensenter {

    private com.forbitbd.stdealers.login.LoginContract.View mview;
    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";

    public LoginPresenter(com.forbitbd.stdealers.login.LoginContract.View mview) {
        this.mview = mview;
        this.mAuth = FirebaseAuth.getInstance();

    }

    public void startAutentication(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Google Sign In was successful, authenticate with Firebase
            GoogleSignInAccount account = result.getSignInAccount();
            firebaseAuthWithGoogle(account);
        } else {
            Log.d("UUUUU", "Not Success " + result.getStatus().getStatusCode());

        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        registerToDatabase(user);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void registerToDatabase(FirebaseUser dealer) {
        Dealer d = new Dealer();

        if (dealer.getEmail() != null) {
            d.setEmail(dealer.getEmail());
        }

        if (dealer.getDisplayName() != null) {
            d.setName(dealer.getDisplayName());
        }

//        if (dealer.getPhoneNumber() != null) {
//            d.setMobile(dealer.getPhoneNumber());
//        }

        if (dealer.getPhotoUrl() != null) {
            d.setImage(dealer.getPhotoUrl().toString());
        }

        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
        Call<Dealer> call = apiClient.register(d);
        call.enqueue(new Callback<Dealer>() {
            @Override
            public void onResponse(Call<Dealer> call, Response<Dealer> response) {

                if (response.isSuccessful()) {
//                    Log.d(TAG, "onResponse: "+dealer);
                    mview.startMainActivity();
                }
            }

            @Override
            public void onFailure(Call<Dealer> call, Throwable t) {
                Log.d("YYYY", "Not Successfull " + t.getMessage());
            }
        });
    }

    @Override
    public void google_click() {
        mview.googleSignIn();
    }
}


