package com.forbitbd.stdealers.models;

public class Device {

    String vehicle_reg, vehicle_type, device_sim, customer_name, customer_phone, customer_email;

    public Device(String vehicle_reg, String vehicle_type, String device_sim, String customer_name, String customer_phone, String customer_email) {
        this.vehicle_reg = vehicle_reg;
        this.vehicle_type = vehicle_type;
        this.device_sim = device_sim;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
    }

    public String getVehicle_reg() {
        return vehicle_reg;
    }

    public void setVehicle_reg(String vehicle_reg) {
        this.vehicle_reg = vehicle_reg;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getDevice_sim() {
        return device_sim;
    }

    public void setDevice_sim(String device_sim) {
        this.device_sim = device_sim;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
}
