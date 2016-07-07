package com.nc.j2ee;

/**
 * Class for order info
 * Created by Vlad on 28.06.2016.
 */
public class OrderInfo {
    /**Attribute - product id*/
    private String productId;
    /**Attribute - product name*/
    private String name;
    /**Attribute - product price*/
    private String price;
    /**Attribute - product order id*/
    private String orderId;
    /**Attribute - product order date*/
    private String date;

    /**
     * Constructor for object OrderInfo
     * @param productId - product id
     * @param name - product name
     * @param price - product price
     * @param orderId - product order id
     * @param date - product order date
     */
    public OrderInfo(String productId, String name, String price, String orderId, String date) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.orderId = orderId;
        this.date = date;
    }

    /**
     *
     * @return productId - product id
     */
    public String getProductId() {
        return productId;
    }

    /**
     *
     * @return name - product name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return price - product price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @return orderId - product order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     *
     * @return date product order date
     */
    public String getDate() {
        return date;
    }
}
