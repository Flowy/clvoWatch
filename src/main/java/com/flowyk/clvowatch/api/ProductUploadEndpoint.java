package com.flowyk.clvowatch.api;

import com.flowyk.clvowatch.Watch;
import com.flowyk.clvowatch.productUpload.ProductFetcher;
import com.flowyk.clvowatch.productUpload.ProductUploader;
import com.flowyk.clvowatch.productUpload.UploadResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ProductUploadEndpoint {

    private final APITransformer apiTransformer;
    private final ProductUploader productUploader;
    private final ProductFetcher productFetcher;

    public ProductUploadEndpoint(APITransformer apiTransformer, ProductUploader productUploader, ProductFetcher productFetcher) {
        this.apiTransformer = apiTransformer;
        this.productUploader = productUploader;
        this.productFetcher = productFetcher;
    }

    @PostMapping(value = "/product")
    void addProduct(@RequestBody WatchAPI requestWatch, HttpServletResponse response) {
        Watch watch = apiTransformer.from(requestWatch);

        Watch exists = productFetcher.load(watch.getTitle());
        if (exists != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with given title already exists");
        }

        UploadResult uploadResult = productUploader.upload(watch);
        if (!uploadResult.isSuccess()) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can not save product");
        }

        response.setStatus(HttpServletResponse.SC_CREATED);

    }

}
