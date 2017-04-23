package com.springapp.mvc.domain.product.robots;

import com.springapp.mvc.util.cart.Product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vladislav on 21.02.2017.
 */
@Entity
@Table(name = "robot", catalog = "hmc_example")
public class Robots implements Serializable, Product{
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "robot_type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String brand;

    @Column(name = "producing_year")
    private int year;

    @Column(name = "robot_condition")
    private String condition = "";

    @Column(name = "location")
    private String location;

    @Column(name = "axes")
    private String axes;

    @Column(name = "robot_load")
    private int load;

    @Column(name = "reach")
    private int reach;

    @Column(name = "footprint")
    private String footprint;

    @Column(name = "repeatability")
    private int repeatability;

    @Column(name = "weight")
    private int weight;

    @Column(name = "price")
    private double price;

    @Column(name = "photo1")
    private String photo1;

    @Column(name = "photo2")
    private String photo2;

    @Column(name = "photo3")
    private String photo3;

    @Column(name = "descriptionen")
    private String descriptionEn;

    @Column(name = "descriptionru")
    private String descriptionRu;

    @Column(name = "video1")
    private String video1;

    @Column(name = "video2")
    private String video2;

    @Column(name = "video3")
    private String video3;

    @Column(name = "sold")
    private String sold;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String manufacturer) {
        this.brand = manufacturer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAxes() {
        return axes;
    }

    public void setAxes(String axes) {
        this.axes = axes;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
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
