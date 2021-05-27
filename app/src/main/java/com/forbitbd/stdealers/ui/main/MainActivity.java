package com.forbitbd.stdealers.ui.main;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.forbitbd.stdealers.WelcomeFragment;
import com.forbitbd.stdealers.ui.fragments.ConnectedFragment;
import com.forbitbd.stdealers.ui.fragments.DeviceEntryFormFragment;
import com.forbitbd.stdealers.ui.fragments.PendingFragment;
import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.adapter.ViewPagerAdapter;
import com.forbitbd.stdealers.ui.profile.ProfileActivity;
import com.forbitbd.stdealers.ui.login.LoginActivity;
import com.forbitbd.stdealers.utils.AppPreference;
import com.forbitbd.stdealers.utils.BaseActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends BaseActivity implements MainContract.View{

    private MainPresenter mPresenter;
    private ExtendedFloatingActionButton btnfab;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PendingFragment pendingFragment;
    private ConnectedFragment connectedFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.updateFirebaseToken();

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        pendingFragment  = new PendingFragment();
        connectedFragment = new ConnectedFragment();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(pendingFragment, "Pending Device");
        viewPagerAdapter.addFragment(connectedFragment, "Connected Device");
        viewPager.setAdapter(viewPagerAdapter);

        if (AppPreference.getInstance(this).getDealer().getIs_active()) {

            WelcomeFragment welcome_fragment = new WelcomeFragment();
            welcome_fragment.setCancelable(false);
            welcome_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
        }
        setupToolbar(R.id.toolbar);
        btnfab = findViewById(R.id.req);
        btnfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceEntryFormFragment dialogboxFragment = new DeviceEntryFormFragment();
                dialogboxFragment.setCancelable(true);
                dialogboxFragment.show(getSupportFragmentManager(), "abcd");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            AppPreference.getInstance(this).setDealer(null);
            signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
