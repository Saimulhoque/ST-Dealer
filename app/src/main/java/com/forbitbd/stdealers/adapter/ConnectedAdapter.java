package com.forbitbd.stdealers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.stdealers.ItemCLickListener;
import com.forbitbd.stdealers.R;
import com.forbitbd.stdealers.models.Device;

import java.util.List;

public class ConnectedAdapter extends RecyclerView.Adapter<ConnectedAdapter.MyViewHolder> {

    private Context context;
    private List<Device> deviceList;
    private ItemCLickListener listener;

    public ConnectedAdapter(Context context, List<Device> deviceList, ItemCLickListener listener) {
        this.context = context;
        this.deviceList = deviceList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_devices,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Device device = deviceList.get(position);
        holder.tv1.setText(device.getVehicle_reg());
        holder.tv2.setText(device.getVehicle_type());
        holder.tv3.setText(device.getDevice_sim());
        holder.tv4.setText(device.getCustomer_name());
        holder.tv5.setText(device.getCustomer_phone());
        holder.tv6.setText(device.getCustomer_email());
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4, tv5, tv6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.vehicle_reg);
            tv2 = itemView.findViewById(R.id.vehicle_type);
            tv3 = itemView.findViewById(R.id.device_sim);
            tv4 = itemView.findViewById(R.id.customer_name);
            tv5 = itemView.findViewById(R.id.customer_phone);
            tv6 = itemView.findViewById(R.id.customer_email);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ItemCLick(getAdapterPosition());
                }
            });
        }
    }
}
