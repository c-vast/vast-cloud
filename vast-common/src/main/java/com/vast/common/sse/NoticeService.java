package com.vast.common.sse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface NoticeService {
    SseEmitter createSseEmitter(String clientId);
    void removeSseEmitter(String clientId);
    boolean sendMessage(String clientId, String content);
}
