package com.donhat.se330.flower_shop_management.frontend.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ImportProductRecord {
    private int id;
    private Product product;
    private int quantity;
    @SerializedName("import_date")
    private Date importDate;

    public ImportProductRecord() {
        id = 0;
        product = new Product();
        quantity = 0;
        importDate = new Date();
    }

    public ImportProductRecord(int id, Product product, int quantity, Date importDate) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }
}
