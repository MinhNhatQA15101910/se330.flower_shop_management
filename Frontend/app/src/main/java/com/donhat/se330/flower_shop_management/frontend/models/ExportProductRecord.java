package com.donhat.se330.flower_shop_management.frontend.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ExportProductRecord {
    private int id;
    private Product product;
    private int quantity;
    @SerializedName("export_date")
    private Date exportDate;

    public ExportProductRecord() {
        id = 0;
        product = new Product();
        quantity = 0;
        exportDate = new Date();
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

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }
}
