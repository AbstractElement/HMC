package com.springapp.mvc.domain.product.hmc;

import com.springapp.mvc.util.cart.Product;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "live_tool", schema = "", catalog = "hmc_example")
public class LiveToolEntity implements Serializable, Product {
    private String productId;

    @Id
    @javax.persistence.Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String manufacturer;

    @Basic
    @javax.persistence.Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String model;

    @Basic
    @javax.persistence.Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private Integer d;

    @Basic
    @javax.persistence.Column(name = "D")
    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    private String toolHolder;

    @Basic
    @javax.persistence.Column(name = "toolHolder")
    public String getToolHolder() {
        return toolHolder;
    }

    public void setToolHolder(String toolHolder) {
        this.toolHolder = toolHolder;
    }

    private String clampingRange;

    @Basic
    @javax.persistence.Column(name = "clampingRange")
    public String getClampingRange() {
        return clampingRange;
    }

    public void setClampingRange(String clampingRange) {
        this.clampingRange = clampingRange;
    }

    private Double s;

    @Basic
    @javax.persistence.Column(name = "s")
    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    private Integer speedMax;

    @Basic
    @javax.persistence.Column(name = "speedMax")
    public Integer getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(Integer speedMax) {
        this.speedMax = speedMax;
    }

    private String i;

    @Basic
    @javax.persistence.Column(name = "i")
    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    private Double a;

    @Basic
    @javax.persistence.Column(name = "a")
    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    private Double b;

    @Basic
    @javax.persistence.Column(name = "b")
    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    private Double c;

    @Basic
    @javax.persistence.Column(name = "c")
    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    private Double e;

    @Basic
    @javax.persistence.Column(name = "e")
    public Double getE() {
        return e;
    }

    public void setE(Double e) {
        this.e = e;
    }

    private Double m;

    @Basic
    @javax.persistence.Column(name = "m")
    public Double getM() {
        return m;
    }

    public void setM(Double m) {
        this.m = m;
    }

    private String codeNo;

    @Basic
    @javax.persistence.Column(name = "codeNo")
    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    private String orderNo;

    @Basic
    @javax.persistence.Column(name = "orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private String coolantSupply;

    @Basic
    @javax.persistence.Column(name = "coolantSupply")
    public String getCoolantSupply() {
        return coolantSupply;
    }

    public void setCoolantSupply(String coolantSupply) {
        this.coolantSupply = coolantSupply;
    }

    private String din;

    @Basic
    @javax.persistence.Column(name = "din")
    public String getDin() {
        return din;
    }

    public void setDin(String din) {
        this.din = din;
    }

    private String isSold;

    @Basic
    @javax.persistence.Column(name = "isSold")
    public String getIsSold() {
        return isSold;
    }

    public void setIsSold(String isSold) {
        this.isSold = isSold;
    }

    private String photo1;

    private String photo2;

    private String photo3;

    @Basic
    @javax.persistence.Column(name = "photo1")
    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    @Basic
    @javax.persistence.Column(name = "photo2")
    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    @Basic
    @javax.persistence.Column(name = "photo3")
    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    @Basic
    @javax.persistence.Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiveToolEntity that = (LiveToolEntity) o;

        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;
        if (c != null ? !c.equals(that.c) : that.c != null) return false;
        if (clampingRange != null ? !clampingRange.equals(that.clampingRange) : that.clampingRange != null)
            return false;
        if (codeNo != null ? !codeNo.equals(that.codeNo) : that.codeNo != null) return false;
        if (coolantSupply != null ? !coolantSupply.equals(that.coolantSupply) : that.coolantSupply != null)
            return false;
        if (d != null ? !d.equals(that.d) : that.d != null) return false;
        if (din != null ? !din.equals(that.din) : that.din != null) return false;
        if (e != null ? !e.equals(that.e) : that.e != null) return false;
        if (i != null ? !i.equals(that.i) : that.i != null) return false;
        if (m != null ? !m.equals(that.m) : that.m != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (s != null ? !s.equals(that.s) : that.s != null) return false;
        if (speedMax != null ? !speedMax.equals(that.speedMax) : that.speedMax != null) return false;
        if (toolHolder != null ? !toolHolder.equals(that.toolHolder) : that.toolHolder != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (toolHolder != null ? toolHolder.hashCode() : 0);
        result = 31 * result + (clampingRange != null ? clampingRange.hashCode() : 0);
        result = 31 * result + (s != null ? s.hashCode() : 0);
        result = 31 * result + (speedMax != null ? speedMax.hashCode() : 0);
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (e != null ? e.hashCode() : 0);
        result = 31 * result + (m != null ? m.hashCode() : 0);
        result = 31 * result + (codeNo != null ? codeNo.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (coolantSupply != null ? coolantSupply.hashCode() : 0);
        result = 31 * result + (din != null ? din.hashCode() : 0);
        return result;
    }
}
