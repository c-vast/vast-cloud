package com.vast.common.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public abstract class BaseEvent extends ApplicationEvent {
    private final int type;
    public BaseEvent(Object source,int type) {
        super(source);
        this.type = type;
    }
}
