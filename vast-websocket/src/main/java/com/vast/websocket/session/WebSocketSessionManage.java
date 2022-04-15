package com.vast.websocket.session;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class WebSocketSessionManage {

    private static final Map<String, Session> WEB_SOCKET_SESSION_MAP = new ConcurrentHashMap<>();

    public static boolean sendMessage(String sessionId, String message) {
        Session session = getSession(sessionId);
        return send(session, message);
    }

    public static void sendMassMessage(String message) {
        Collection<Session> sessions = WEB_SOCKET_SESSION_MAP.values();
        for (Session session : sessions) {
            send(session, message);
        }
    }

    public static boolean containsSession(String sessionId) {
        return WEB_SOCKET_SESSION_MAP.containsKey(sessionId);
    }

    public static void addSession(String sessionId, Session session) {
        WEB_SOCKET_SESSION_MAP.put(sessionId, session);
    }

    public static void removeSession(String sessionId) {
        WEB_SOCKET_SESSION_MAP.remove(sessionId);
    }

    public static Session getSession(String sessionId) {
        if (WEB_SOCKET_SESSION_MAP.containsKey(sessionId)) {
            return WEB_SOCKET_SESSION_MAP.get(sessionId);
        }
        return null;
    }

    private static boolean send(Session session, String message) {
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
                return true;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return false;
    }
}
