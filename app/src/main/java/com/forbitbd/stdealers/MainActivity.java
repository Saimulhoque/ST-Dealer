package com.forbitbd.stdealers;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.forbitbd.stdealers.login.LoginActivity;
import com.forbitbd.stdealers.utils.BaseActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends BaseActivity {

    private ExtendedFloatingActionButton btnfab;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PendingFragment pendingFragment;
    private ConnectedFragment connectedFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        pendingFragment  = new PendingFragment();
        connectedFragment = new ConnectedFragment();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(pendingFragment, "Pending Device");
        viewPagerAdapter.addFragment(connectedFragment, "Connected Device");
        viewPager.setAdapter(viewPagerAdapter);

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
            signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
