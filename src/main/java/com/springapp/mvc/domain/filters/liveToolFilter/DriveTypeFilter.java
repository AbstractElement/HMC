package com.springapp.mvc.domain.filters.liveToolFilter;

import javax.persistence.*;

/**
 * Created by Vladislav on 25.03.2017.
 */
@Entity
@Table(name = "filter_drivetype", schema = "", catalog = "hmc_example")
public class DriveTypeFilter{
    private String driveType;
    private int num;

    @Id
    @Column(name = "driveType")
    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
