package com.springapp.mvc.domain.filters.hmcFilter;

/**
 * Created by Vladislav on 27.03.2017.
 */
public class MainLiveToolFilter {
    private String brand;
    private String country;
    private String VDI;
    private String driveType;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVDI() {
        return VDI;
    }

    public void setVDI(String VDI) {
        this.VDI = VDI;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }
}
