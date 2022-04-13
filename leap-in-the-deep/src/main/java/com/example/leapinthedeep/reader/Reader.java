package com.example.leapinthedeep.reader;

public class Reader {

    private String fullName;
    private String userName;
    private String pass;
    private String email;
    private String phoneNo;

    public boolean isEmailValid() {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return this.email.matches(regex);
    }

    public boolean isPhoneNoValid() {
        String regex = "\\D+\\d{10}$";
        return this.phoneNo.matches(regex);
    }
}
