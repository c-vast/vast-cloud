package com.vast.common.component;

import com.vast.common.config.properties.TokenProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTOperator {

    @Autowired
    private TokenProperties tokenProperties;
}
