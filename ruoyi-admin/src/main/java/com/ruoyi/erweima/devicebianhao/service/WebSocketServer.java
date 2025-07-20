package com.ruoyi.erweima.devicebianhao.service;

// WebSocketServer.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    private static final CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("WebSocket连接建立: {}", session.getId());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("WebSocket连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到客户端消息: {}", message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("WebSocket发生错误: {}", error.getMessage(), error);
    }

    public static void sendInfo(String message) {
        for (WebSocketServer server : webSocketSet) {
            try {
                server.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.error("消息发送失败: {}", e.getMessage(), e);
            }
        }
        log.info("广播消息: {}", message);
    }
}