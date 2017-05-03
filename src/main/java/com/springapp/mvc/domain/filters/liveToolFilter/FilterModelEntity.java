package com.springapp.mvc.domain.filters.liveToolFilter;

import javax.persistence.*;

/**
 * Created by Vladislav on 02.05.2017.
 */
@Entity
@Table(name = "filter_model", schema = "", catalog = "hmc_example")
public class FilterModelEntity {
    private String model;
    private Integer num;

    @Id
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterModelEntity that = (FilterModelEntity) o;

        if (model != that.model) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }
}
