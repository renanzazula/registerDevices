package com.clx.registerDevices.exceptions;

public class UserNotFoundException extends Exception {
    private String code;
    public UserNotFoundException(String code, String msg) {
        // Call constructor of parent Exception
        super(code);
    }

}
