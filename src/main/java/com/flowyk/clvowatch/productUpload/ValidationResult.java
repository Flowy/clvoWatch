package com.flowyk.clvowatch.productUpload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ValidationResult implements UploadResult {

    public static class Fails {
        public static final String MISSING_PRICE = "missing_price";
        public static final String UNKNOWN_FOUNTAIN_FORMAT = "unknown_fountain_format";
        public static final String MISSING_TITLE = "missing_title";
    }

    private final List<String> failedReasons = new ArrayList<>();

    @Override
    public boolean isSuccess() {
        return failedReasons.size() == 0;
    }

    @Override
    public Collection<String> failReasons() {

        return Collections.unmodifiableList(failedReasons);
    }

    void failed(String reasonCode) {
        failedReasons.add(reasonCode);
    }
}
