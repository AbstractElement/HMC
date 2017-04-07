package com.springapp.mvc.domain.filters.hmcFilter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 27.03.2017.
 */
@Entity
@Table(catalog = "hmc_example", name = "filter_toolholder")
public class ToolHolderFilter {
    @Id
    private String toolHolder;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getToolHolder() {
        return toolHolder;
    }

    public void setToolHolder(String toolHolder) {
        this.toolHolder = toolHolder;
    }
}
