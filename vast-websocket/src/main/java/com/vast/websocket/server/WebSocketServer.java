package com.vast.websocket.server;

import com.vast.websocket.session.WebSocketSessionManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@Component
@ServerEndpoint("/webSocket/{userId}")
public class WebSocketServer {

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        WebSocketSessionManage.addSession(userId, session);
    }

    @OnClose
    public void onClose(@PathParam("userId") String userId) {
        WebSocketSessionManage.removeSession(userId);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error(error.getMessage(), error);
    }

    @OnMessage
    public void onMessage(@PathParam("userId") String userId, String message) {
        log.info("【websocket消息】userId【{}】推送消息, message={}",userId, message);
    }
}
