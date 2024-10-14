package com.example.codesynctest.company;

public class Company {
    private String companyName;
    private int companyImage;

    public Company(String companyName, int companyImage) {
        this.companyName = companyName;
        this.companyImage = companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyImage() {
        return companyImage;
    }
}
