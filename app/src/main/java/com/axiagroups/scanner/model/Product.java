package com.axiagroups.scanner.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    int productId;
    @ColumnInfo(name = "create_date")
    String createDate;
    @ColumnInfo(name = "qr_data")
    String qrData;



    public Product() {

    }

    public Product(String createDate, String qrData) {
        this.createDate = createDate;
        this.qrData = qrData;
    }

    public Product(int productId, String createDate, String qrData) {
        this.productId = productId;
        this.createDate = createDate;
        this.qrData = qrData;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }
}
