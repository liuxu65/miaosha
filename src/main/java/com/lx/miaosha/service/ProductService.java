package com.lx.miaosha.service;

import com.lx.miaosha.model.ProductModel;

import java.util.List;

public interface ProductService {

    //创建商品
    ProductModel createProduct(ProductModel productModel);

    //商品列表浏览
    List<ProductModel> listProduct();

    //商品详情浏览
    ProductModel getProduct(Integer id);
}
