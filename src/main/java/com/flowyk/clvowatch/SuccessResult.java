package com.flowyk.clvowatch;

public class SuccessResult implements UploadResult {

    private static SuccessResult instance = new SuccessResult();

    public static SuccessResult getInstance() {
        return instance;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
