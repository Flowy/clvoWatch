package com.flowyk.clvowatch.productUpload;

import java.util.Collection;
import java.util.Collections;

public class SuccessResult implements UploadResult {

    private static final SuccessResult instance = new SuccessResult();

    public static SuccessResult getInstance() {
        return instance;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public Collection<String> failReasons() {
        return Collections.emptyList();
    }
}
