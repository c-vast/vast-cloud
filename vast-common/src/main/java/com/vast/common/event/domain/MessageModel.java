package com.vast.common.event.domain;

import lombok.Data;

@Data
public class MessageModel {

    private String message;
    private boolean push;
    private boolean queue;
    private String destinationName;
}
