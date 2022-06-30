package com.example.wjconstraction;

import android.widget.TextView;

public class Admin {
    private String id;
    private String name;
    private String nic;
    private String number;
    private String address;
    private String email;
    private String password;

    public Admin(String id, String name, String nic, String number, String address, String email, String password) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.number = number;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public Admin(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Admin() {
        this.id = "";
        this.name = "";
        this.nic = "";
        this.number = "";
        this.address = "";
        this.email = "";
        this.password = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
