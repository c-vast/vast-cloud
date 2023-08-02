package com.vast.common.datadesensitization;

import java.util.function.Function;

public enum DataDesensitizationStrategy {
    /**
     * 用户名
     */
    USERNAME(s -> s.replaceAll("(\\S)\\S(\\S*)", "$1*$2")),
    /**
     * 身份证
     */
    ID_CARD(s -> s.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1****$2")),
    /**
     * 手机号
     */
    PHONE(s -> s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")),
    /**
     * 地址
     */
    ADDRESS(s -> s.replaceAll("(\\S{3})\\S{2}(\\S*)\\S{2}", "$1****$2****"));

    private final Function<String, String> desensitization;

    DataDesensitizationStrategy(Function<String, String> desensitization) {
        this.desensitization = desensitization;
    }

    public Function<String, String> getDesensitization() {
        return desensitization;
    }
}
