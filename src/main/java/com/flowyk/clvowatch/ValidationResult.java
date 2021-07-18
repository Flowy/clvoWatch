package com.flowyk.clvowatch;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult implements UploadResult {

    private List<String> failedReasons = new ArrayList<>();

    @Override
    public boolean isSuccess() {
        return failedReasons.size() == 0;
    }


    void failed(String reasonCode) {
        failedReasons.add(reasonCode);
    }
}
