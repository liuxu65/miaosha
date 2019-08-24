package com.lx.miaosha.service.impl;

import com.lx.miaosha.dao.ProductDOMapper;
import com.lx.miaosha.dao.ProductStockDOMapper;
import com.lx.miaosha.entity.ProductDO;
import com.lx.miaosha.entity.ProductStockDO;
import com.lx.miaosha.model.ProductModel;
import com.lx.miaosha.service.ProductService;
import com.lx.miaosha.validator.ValidationResult;
import com.lx.miaosha.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private ProductDOMapper productDOMapper;
    @Autowired
    private ProductStockDOMapper productStockDOMapper;

    private ProductDO convertProductDo(ProductModel productModel){
        if(productModel==null)
        {
            return null;
        }
        ProductDO productDO=new ProductDO();
        BeanUtils.copyProperties(productModel,productDO);
        productDO.setPrice(productModel.getPrice().doubleValue());
        return productDO;
    }

    private ProductStockDO convertProductStockDO(ProductModel productModel){
        if(productModel==null){
            return null;
        }
        ProductStockDO productStockDO=new ProductStockDO();
        productStockDO.setId(productModel.getId());
        productStockDO.setStock(productModel.getStock());
        productStockDO.setProductId(productModel.getId());
        return productStockDO;
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        //校验入参
//        boolean hasErrors = validator.validate(productModel).isHasErrors();

        //转化ProductModel->Entity
        ProductDO productDO=this.convertProductDo(productModel);

        //写入数据库
        productDOMapper.insertSelective(productDO);

        ProductStockDO productStockDO=this.convertProductStockDO(productModel);
        productStockDOMapper.insertSelective(productStockDO);
        return this.getProduct(productModel.getId());
    }

    @Override
    public List<ProductModel> listProduct() {
        return null;
    }

    @Override
    public ProductModel getProduct(Integer id) {
        ProductDO productDO=productDOMapper.selectByPrimaryKey(id);
        if(productDO==null)
        {
            return null;
        }
        else{
            //操作获得库存数量
            ProductStockDO productStockDO = productStockDOMapper.selectByProductId(productDO.getId());
        }
        return null;
    }
}
