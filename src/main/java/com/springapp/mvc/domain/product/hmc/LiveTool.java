//    package com.springapp.mvc.domain.product.hmc;
//
//import com.springapp.mvc.util.cart.Product;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name="drive_heads", schema = "", catalog = "hmc_example")
//public class LiveTool implements Serializable, Product{
//
//    @Id
//    @Column(name = "productId")
//    private String productId;
//
//    @Column(name = "type")
//    private String type;
//
//    @Column(name = "instrumentTypeEn")
//    private String instrumentTypeEn;
//
//    @Column(name = "instrumentTypeRu")
//    private String instrumentTypeRu;
//
//    @Column(name = "model")
//    private String model;
//
//    @Column(name = "brand")
//    private String brand;
//
//    @Column(name = "producingCountry")
//    private String producingCountry;
//
//    @Column(name = "landingDiameter")
//    private String landingDiameter;
//
//    @Column(name = "driveType")
//    private String driveType;
//
//    @Column(name = "toolHolder")
//    private String toolHolder;
//
//    @Column(name = "clampingRange")
//    private String clampingRange;
//
//    @Column(name = "n1n2")
//    private String n1_n2;
//
//    @Column(name = "torqueMax")
//    private String torqueMax;
//
//    @Column(name = "lengthWorkingPart")
//    private String lengthWorkingPart;
//
//    @Column(name = "displacement")
//    private String displacement;
//
//    @Column(name = "internalSupply")
//    private String internalSupply;
//
//    @Column(name = "weight")
//    private int weight;
//
//    @Column(name = "price")
//    private double price;
//
//    @Column(name = "drawing")
//    private String drawing;
//
//    @Column(name = "photo1")
//    private String photo1;
//
//    @Column(name = "photo2")
//    private String photo2;
//
//    @Column(name = "photo3")
//    private String photo3;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "isSold")
//    private String isSold;
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getProducingCountry() {
//        return producingCountry;
//    }
//
//    public void setProducingCountry(String producingCountry) {
//        this.producingCountry = producingCountry;
//    }
//
//    public String getClampingRange() {
//        return clampingRange;
//    }
//
//    public void setClampingRange(String clampingRange) {
//        this.clampingRange = clampingRange;
//    }
//
//    public String getN1_n2() {
//        return n1_n2;
//    }
//
//    public void setN1_n2(String n1_n2) {
//        this.n1_n2 = n1_n2;
//    }
//
//    public String getTorqueMax() {
//        return torqueMax;
//    }
//
//    public void setTorqueMax(String torqueMax) {
//        this.torqueMax = torqueMax;
//    }
//
//    public String getLengthWorkingPart() {
//        return lengthWorkingPart;
//    }
//
//    public void setLengthWorkingPart(String lengthWorkingPart) {
//        this.lengthWorkingPart = lengthWorkingPart;
//    }
//
//    public String getDisplacement() {
//        return displacement;
//    }
//
//    public void setDisplacement(String displacement) {
//        this.displacement = displacement;
//    }
//
//    public String getInternalSupply() {
//        return internalSupply;
//    }
//
//    public void setInternalSupply(String internalSupply) {
//        this.internalSupply = internalSupply;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getDrawing() {
//        return drawing;
//    }
//
//    public void setDrawing(String drawing) {
//        this.drawing = drawing;
//    }
//
//    public String getPhoto1() {
//        return photo1;
//    }
//
//    public void setPhoto1(String photo1) {
//        this.photo1 = photo1;
//    }
//
//    public String getPhoto3() {
//        return photo3;
//    }
//
//    public void setPhoto3(String photo3) {
//        this.photo3 = photo3;
//    }
//
//    public String getIsSold() {
//        return isSold;
//    }
//
//    public void setIsSold(String isSold) {
//        this.isSold = isSold;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getPhoto2() {
//        return photo2;
//    }
//
//    public void setPhoto2(String photo2) {
//        this.photo2 = photo2;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getInstrumentTypeEn() {
//        return instrumentTypeEn;
//    }
//
//    public void setInstrumentTypeEn(String instrumentTypeEn) {
//        this.instrumentTypeEn = instrumentTypeEn;
//    }
//
//    public String getInstrumentTypeRu() {
//        return instrumentTypeRu;
//    }
//
//    public void setInstrumentTypeRu(String instrumentTypeRu) {
//        this.instrumentTypeRu = instrumentTypeRu;
//    }
//
//    public String getLandingDiameter() {
//        return landingDiameter;
//    }
//
//    public void setLandingDiameter(String landingDiameter) {
//        this.landingDiameter = landingDiameter;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getDriveType() {
//        return driveType;
//    }
//
//    public void setDriveType(String driveType) {
//        this.driveType = driveType;
//    }
//
//    public String getToolHolder() {
//        return toolHolder;
//    }
//
//    public void setToolHolder(String toolHolder) {
//        this.toolHolder = toolHolder;
//    }
//}
