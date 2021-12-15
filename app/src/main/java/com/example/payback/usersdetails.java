package com.example.payback;

public class usersdetails {
    String myname, password;

    public usersdetails() {
    }

    public usersdetails(String myname, String password) {
        this.myname = myname;
        this.password = password;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getOthername() {
        return password;
    }

    public void setOthername(String password) {
        this.password = password;
    }
}
