package com.santhosh.EventDrivenApp.query.api.projection;

import com.santhosh.EventDrivenApp.command.api.data.Product;
import com.santhosh.EventDrivenApp.command.api.data.ProductRepository;
import com.santhosh.EventDrivenApp.command.api.model.ProductRestModel;
import com.santhosh.EventDrivenApp.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products = productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder().quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName()).build())
                        .collect(Collectors.toList());

        return productRestModels;
    }
}