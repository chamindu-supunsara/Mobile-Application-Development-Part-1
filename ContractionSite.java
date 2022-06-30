package com.example.wjconstraction;

public class ContractionSite {
    private String siteid;
    private String sitename;
    private String location;
    private String supervisorname;

    public ContractionSite(String siteid, String sitename, String location, String supervisorname) {
        this.siteid = siteid;
        this.sitename = sitename;
        this.location = location;
        this.supervisorname = supervisorname;
    }

    public ContractionSite() {
        this.siteid = "";
        this.sitename = "";
        this.location = "";
        this.supervisorname = "";
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupervisorname() {
        return supervisorname;
    }

    public void setSupervisorname(String supervisorname) {
        this.supervisorname = supervisorname;
    }
}
