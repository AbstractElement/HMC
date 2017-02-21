package com.springapp.mvc.domain.robots;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 21.02.2017.
 */
@Entity
@Table(name = "robots", catalog = "hmc_example")
public class Robots {
    @Id
    @Column(name = "")
    private int id;

    @Column(name = "")
    private String productId;

    @Column(name = "")
    private String type;

    @Column(name = "")
    private String model;

    @Column(name = "")
    private String manufacturer;

    @Column(name = "")
    private String year;

    @Column(name = "")
    private String condition;

    @Column(name = "")
    private String location;

    @Column(name = "")
    private int axes;

    @Column(name = "")
    private int load;

    @Column(name = "")
    private int reach;

    @Column(name = "")
    private String footprint;

    @Column(name = "")
    private int repeatability;

    @Column(name = "")
    private int weight;

    @Column(name = "")
    private int price;

    @Column(name = "")
    private String photo1;

    @Column(name = "")
    private String photo2;

    @Column(name = "")
    private String photo3;

    @Column(name = "")
    private String descriptionEn;

    @Column(name = "")
    private String getDescriptionRu;

    @Column(name = "")
    private String video1;

    @Column(name = "")
    private String video2;

    @Column(name = "")
    private String video3;

    @Column(name = "")
    private String sold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAxes() {
        return axes;
    }

    public void setAxes(int axes) {
        this.axes = axes;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getFootprint() {
        return footprint;
    }

    public void setFootprint(String footprint) {
        this.footprint = footprint;
    }

    public int getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(int repeatability) {
        this.repeatability = repeatability;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getGetDescriptionRu() {
        return getDescriptionRu;
    }

    public void setGetDescriptionRu(String getDescriptionRu) {
        this.getDescriptionRu = getDescriptionRu;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getVideo1() {
        return video1;
    }

    public void setVideo1(String video1) {
        this.video1 = video1;
    }

    public String getVideo2() {
        return video2;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }

    public String getVideo3() {
        return video3;
    }

    public void setVideo3(String video3) {
        this.video3 = video3;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }
}
