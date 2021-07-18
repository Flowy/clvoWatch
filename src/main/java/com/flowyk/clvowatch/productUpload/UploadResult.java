package com.flowyk.clvowatch.productUpload;

import java.util.Collection;

public interface UploadResult {

    boolean isSuccess();
    Collection<String> failReasons();

}
