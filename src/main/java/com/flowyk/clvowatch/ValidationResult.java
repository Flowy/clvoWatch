package com.flowyk.clvowatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ValidationResult implements UploadResult {

    public static class Fails {
        public static String MISSING_TITLE = "missing_title";
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
