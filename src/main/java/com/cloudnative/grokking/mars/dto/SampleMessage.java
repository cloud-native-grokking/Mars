package com.cloudnative.grokking.mars.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class SampleMessage implements Serializable {
    private String content;
}