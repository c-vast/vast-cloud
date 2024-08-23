package com.vast.common.event;

import com.vast.common.event.domain.MessageModel;
import lombok.Getter;

@Getter
public class MessageEvent extends BaseEvent {
    private final MessageModel content;
    public MessageEvent(Object source, int type, MessageModel content) {
        super(source,type);
        this.content = content;
    }
}
