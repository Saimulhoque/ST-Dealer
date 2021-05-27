package com.forbitbd.stdealers.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.forbitbd.stdealers.api.ApiClient;
import com.forbitbd.stdealers.api.ServiceGenerator;
import com.forbitbd.stdealers.models.Dealer;
import com.forbitbd.stdealers.utils.AppPreference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void updateFirebaseToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("hhhh", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        Dealer dealer = AppPreference.getInstance((Context) mView).getDealer();
                        dealer.setFcm_token(token);

                        ApiClient client = ServiceGenerator.createService(ApiClient.class);
                        client.updateDealer(dealer.getEmail(), dealer)
                                .enqueue(new Callback<Dealer>() {
                                    @Override
                                    public void onResponse(Call<Dealer> call, Response<Dealer> response) {
                                        if (response.isSuccessful()) {
                                            Log.d("HHHHH", response.body().getFcm_token());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Dealer> call, Throwable t) {

                                    }
                                });
                    }
                });
    }
}
