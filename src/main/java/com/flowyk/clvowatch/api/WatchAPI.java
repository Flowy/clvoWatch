package com.flowyk.clvowatch.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatchAPI {

    @JsonProperty
    public String title;

    @JsonProperty
    public Integer price;

    @JsonProperty
    public String description;

    @JsonProperty
    public String fountain;
}
