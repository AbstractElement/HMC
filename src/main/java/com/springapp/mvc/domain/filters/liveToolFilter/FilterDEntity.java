package com.springapp.mvc.domain.filters.liveToolFilter;

import javax.persistence.*;

/**
 * Created by Vladislav on 02.05.2017.
 */
@Entity
@Table(name = "filter_d", schema = "", catalog = "hmc_example")
public class FilterDEntity {
    private int value;
    private Integer num;

    @Id
    @Column(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

        FilterDEntity that = (FilterDEntity) o;

        if (value != that.value) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        return result;
    }
}
