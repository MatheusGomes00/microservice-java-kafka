package com.pb.challangeThree.msUser.exception;

public class PasswordViolationException extends RuntimeException {

    public PasswordViolationException (String message) {
        super(message);
    }
}
