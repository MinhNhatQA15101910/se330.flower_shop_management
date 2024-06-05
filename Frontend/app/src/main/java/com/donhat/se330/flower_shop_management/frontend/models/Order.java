package com.donhat.se330.flower_shop_management.frontend.models;

import com.donhat.se330.flower_shop_management.frontend.constants.enums.OrderStatus;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("product_price")
    private double productPrice;
    @SerializedName("shipping_price")
    private double shippingPrice;
    private OrderStatus status;
    @SerializedName("estimated_receive_date")
    private Date estimatedReceiveDate;
    @SerializedName("order_date")
    private Date orderDate;
    @SerializedName("in_delivery_date")
    private Date inDeliveryDate;
    @SerializedName("receive_date")
    private Date receiveDate;
    private String province;
    private String district;
    private String ward;
    @SerializedName("detail_address")
    private String detailAddress;
    @SerializedName("receiver_name")
    private String receiverName;
    @SerializedName("receiver_phone_number")
    private String receiverPhoneNumber;
    private List<Product> products;
    private List<Integer> quantities;

    public Order() {
        id = 0;
        userId = 0;
        productPrice = 0;
        shippingPrice = 0;
        status = OrderStatus.PENDING;
        estimatedReceiveDate = new Date();
        orderDate = new Date();
        inDeliveryDate = new Date();
        receiveDate = new Date();
        province = "";
        district = "";
        ward = "";
        detailAddress = "";
        receiverName = "";
        receiverPhoneNumber = "";
        products = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public Order(int id, int userId, double productPrice, double shippingPrice, OrderStatus status, Date estimatedReceiveDate, Date orderDate, Date inDeliveryDate, Date receiveDate, String province, String district, String ward, String detailAddress, String receiverName, String receiverPhoneNumber, List<Product> products, List<Integer> quantities) {
        this.id = id;
        this.userId = userId;
        this.productPrice = productPrice;
        this.shippingPrice = shippingPrice;
        this.status = status;
        this.estimatedReceiveDate = estimatedReceiveDate;
        this.orderDate = orderDate;
        this.inDeliveryDate = inDeliveryDate;
        this.receiveDate = receiveDate;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.detailAddress = detailAddress;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.products = products;
        this.quantities = quantities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getEstimatedReceiveDate() {
        return estimatedReceiveDate;
    }

    public void setEstimatedReceiveDate(Date estimatedReceiveDate) {
        this.estimatedReceiveDate = estimatedReceiveDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getInDeliveryDate() {
        return inDeliveryDate;
    }

    public void setInDeliveryDate(Date inDeliveryDate) {
        this.inDeliveryDate = inDeliveryDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }
}
