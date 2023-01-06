package com.vast.common.sse.impl;

import com.vast.common.sse.NoticeService;
import com.vast.common.util.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final Map<String,SseEmitter> stringSseEmitterMap=new ConcurrentHashMap<>();


    @Override
    public SseEmitter createSseEmitter(String clientId) {
        if (StringUtils.isBlank(clientId)){
            clientId= IdUtils.getUUID();
        }
        SseEmitter sseEmitter = new SseEmitter(0L);
        stringSseEmitterMap.put(clientId,sseEmitter);
        return sseEmitter;
    }

    @Override
    public void removeSseEmitter(String clientId) {
        if (stringSseEmitterMap.containsKey(clientId)){
            SseEmitter sseEmitter = stringSseEmitterMap.get(clientId);
            stringSseEmitterMap.remove(clientId);
            sseEmitter.complete();
        }
    }

    @Override
    public boolean sendMessage(String clientId, String content) {
        if (stringSseEmitterMap.containsKey(clientId)){
            SseEmitter sseEmitter = stringSseEmitterMap.get(clientId);
            try {
                sseEmitter.send(clientId);
                return true;
            } catch (IOException e) {
                log.error(e.getMessage(),e);
            }
        }
        return false;
    }
}
