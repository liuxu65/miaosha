package com.lx.miaosha.entity;

public class ProductStockDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_stock.id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_stock.stock
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    private Integer stock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_stock.product_id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    private Integer productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_stock.id
     *
     * @return the value of product_stock.id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_stock.id
     *
     * @param id the value for product_stock.id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_stock.stock
     *
     * @return the value of product_stock.stock
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_stock.stock
     *
     * @param stock the value for product_stock.stock
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_stock.product_id
     *
     * @return the value of product_stock.product_id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_stock.product_id
     *
     * @param productId the value for product_stock.product_id
     *
     * @mbggenerated Thu Aug 15 16:48:05 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}