package com.lx.miaosha.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductModel {
    private Integer id;
    @NotBlank(message = "商品名字不能为空")
    private String title;//名称

    @NotBlank(message = "价格不能为空")
    @Min(value = 0,message = "商品价格必须大于0")
    private BigDecimal price;//价格

    @NotBlank(message = "库存不能不填")
    private Integer stock;//库存

    @NotBlank(message = "商品描述信息不能为空")
    private  String description;//描述
    private Integer sales;//销量

    @NotBlank(message = "图片不能为空")
    private String imgUrl;//图片

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
