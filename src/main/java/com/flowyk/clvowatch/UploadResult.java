package com.flowyk.clvowatch;

import java.util.Collection;

public interface UploadResult {

    boolean isSuccess();
    Collection<String> failReasons();

}
