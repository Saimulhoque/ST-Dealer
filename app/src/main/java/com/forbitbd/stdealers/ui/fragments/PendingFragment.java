package com.forbitbd.stdealers.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.adapter.ConnectedAdapter;
import com.forbitbd.stdealers.adapter.PendingAdapter;
import com.forbitbd.stdealers.models.Device;

import java.util.ArrayList;

public class PendingFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Device> deviceList;
    private PendingAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    public PendingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        deviceList = new ArrayList<>();
        deviceList.add(new Device("Dhaka Metro 12-5783", "Truck", "01824465858", "Saimul Hoque", "01881269553", "saimulhqoue8217@gmail.com"));
        adapter = new PendingAdapter(getContext(), deviceList);
        recyclerView.setAdapter(adapter);

        refreshLayout = view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                refreshData();
            }
        });
        return view;
    }

    private void refreshData() {
        refreshLayout.setRefreshing(false);
    }
}