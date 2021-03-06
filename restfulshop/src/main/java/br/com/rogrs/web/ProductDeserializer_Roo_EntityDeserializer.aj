// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.com.rogrs.web;

import br.com.rogrs.model.Product;
import br.com.rogrs.service.api.ProductService;
import br.com.rogrs.web.ProductDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.core.convert.ConversionService;

privileged aspect ProductDeserializer_Roo_EntityDeserializer {
    
    declare @type: ProductDeserializer: @JsonComponent;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ProductService
     */
    public ProductService ProductDeserializer.getProductService() {
        return productService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param productService
     */
    public void ProductDeserializer.setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ConversionService
     */
    public ConversionService ProductDeserializer.getConversionService() {
        return conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param conversionService
     */
    public void ProductDeserializer.setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Product
     * @throws IOException
     */
    public Product ProductDeserializer.deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Product product = productService.findOne(id);
        if (product == null) {
            throw new NotFoundException("Product not found");
        }
        return product;
    }
    
}
