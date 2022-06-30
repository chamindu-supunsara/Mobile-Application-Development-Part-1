package com.example.wjconstraction;

public class Worker {

    private String id;
    private String name;
    private String nic;
    private String phone;
    private String address;

    public Worker(String id, String name, String nic, String phone, String address) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
    }

    public Worker() {
        this.id = "";
        this.name = "";
        this.nic = "";
        this.phone = "";
        this.address = "";
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
