package com.cloudnative.grokking.mars.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("mercury")
public class YAMLConfig {
    MercuryConfig mercury;

    public MercuryConfig getMercury() {
        return mercury;
    }

    public void setMercury(MercuryConfig mercury) {
        this.mercury = mercury;
    }
}
