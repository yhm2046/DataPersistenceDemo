package com.example.datapersistencedemo;

/**
 * 2022.10.9    Sunday
 * 多媒体类
 */
public class MultipleMedia {
    private String logo;
    private String companyName;
    private String telephone;
    private String website;
    private String code;
    private String slogan;

    MultipleMedia(String logo,
                  String companyName,
                  String telephone,
                  String website,
                  String code,
                  String slogan){
        this.code = code;
        this.companyName = companyName;
        this.telephone = telephone;
        this.website = website;
        this.logo = logo;
        this.slogan = slogan;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
