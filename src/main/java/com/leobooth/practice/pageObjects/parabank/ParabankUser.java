package com.leobooth.practice.pageObjects.parabank;

import io.github.cdimascio.dotenv.Dotenv;

public class ParabankUser {
    public String username;
    public String password;
    public String fullName;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phoneNumber;
    public String SSN;

    public ParabankUser(Dotenv envVars) {
        this.username = envVars.get("PARABANK_USERNAME");
        this.password = envVars.get("PARABANK_PASSWORD");
        this.fullName = envVars.get("PARABANK_CUSTOMER_FULL_NAME");
        this.firstName = envVars.get("PARABANK_CUSTOMER_FIRST_NAME");
        this.lastName = envVars.get("PARABANK_CUSTOMER_LAST_NAME");
        this.address = envVars.get("PARABANK_CUSTOMER_ADDRESS");
        this.city = envVars.get("PARABANK_CUSTOMER_CITY");
        this.state = envVars.get("PARABANK_CUSTOMER_STATE");
        this.zipCode = envVars.get("PARABANK_CUSTOMER_ZIP_CODE");
        this.phoneNumber = envVars.get("PARABANK_CUSTOMER_PHONE_NUMBER");
        this.SSN = envVars.get("PARABANK_CUSTOMER_SSN");
    }
}
