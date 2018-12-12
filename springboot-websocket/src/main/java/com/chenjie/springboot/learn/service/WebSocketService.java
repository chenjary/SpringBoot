package com.chenjie.springboot.learn.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
@Component
public class WebSocketService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static int COUNT = 0;

    private static CopyOnWriteArraySet<WebSocketService> websocket = new CopyOnWriteArraySet<WebSocketService>();

    private Session session;

    /*
    建立连接的时候调用
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocket.add(this);
        addOnlineCount();
        log.info("当前在线人数：" + COUNT);
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onclose() {
        websocket.remove(this);
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /*
    接收到客户端的信息
     */
    @OnMessage
    public void shoudaoMessage(String message, Session session) {
        log.info("server 收到的信息是：" + message);
        //群发消息
        for (WebSocketService item : websocket) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        for (WebSocketService item : websocket) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return COUNT;
    }

    public static synchronized void addOnlineCount() {

        WebSocketService.COUNT++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.COUNT--;
    }
}