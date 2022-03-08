package com.example.meridianjobs;

public class model {
    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public String getE_adrs() {
        return e_adrs;
    }

    public void setE_adrs(String e_adrs) {
        this.e_adrs = e_adrs;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public String getE_cont() {
        return e_cont;
    }

    public void setE_cont(String e_cont) {
        this.e_cont = e_cont;
    }

    String e_name,e_email,e_adrs,e_pass,e_cont;

    public model() {
        this.e_name = e_name;
        this.e_email = e_email;
        this.e_adrs = e_adrs;
        this.e_pass = e_pass;
        this.e_cont = e_cont;
    }
}
