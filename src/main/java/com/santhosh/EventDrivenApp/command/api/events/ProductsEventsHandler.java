package com.santhosh.EventDrivenApp.command.api.events;

import com.santhosh.EventDrivenApp.command.api.data.Product;
import com.santhosh.EventDrivenApp.command.api.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductsEventsHandler {

    private ProductRepository productRepository;

    public ProductsEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        productRepository.save(product);
    }
}
