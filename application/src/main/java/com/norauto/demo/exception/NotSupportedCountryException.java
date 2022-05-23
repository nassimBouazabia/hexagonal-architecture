package com.norauto.demo.exception;

public class NotSupportedCountryException extends RuntimeException {
    public NotSupportedCountryException(String countryCode) {
        super(countryCode);
    }
}
