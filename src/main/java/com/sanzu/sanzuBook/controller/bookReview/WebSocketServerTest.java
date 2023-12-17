package com.sanzu.sanzuBook.controller.bookReview;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class WebSocketServerTest extends WebSocketServer {
    private List<WebSocket> connections;
    public WebSocketServerTest(InetSocketAddress address) {
        super(address);
        connections = new ArrayList<>();
    }

    /**
     * 当有新的WebSocket连接建立时，
     * 这个方法会被调用。在这个方法中，
     * 可以执行与新连接相关的任务，
     * 比如发送欢迎消息给新客户端，
     * 广播连接信息等。
     * @param webSocket 在 WebSocket
     * 事件方法中作为参数传递的对象，
     * 用于表示与客户端建立的 WebSocket 连接
     * @param clientHandshake ClientHandshake
     * 是一个包含客户端握手信息的对象。
     * 它是 org.java_websocket.handshake.ClientHandshake
     * 类的一个实例。
     */
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        connections.add(webSocket);
        System.out.println(webSocket+"的连接建立了");
    }

    /**
     * 当WebSocket连接关闭时，
     * 这个方法会被调用。
     * 在这个方法中，
     * 可以处理连接关闭的逻辑，比如输出连接关闭的信息。
     * @param webSocket 同
     * @param i 1
     * @param s 1
     * @param b 1
     */
    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        connections.remove(webSocket);
        System.out.println(webSocket+"的连接被断开了");
    }
    /**
     * 当从客户端接收到文本消息时，
     * 这个方法会被调用。
     * 在这个方法中，可以对接收到的消息进行处理，比如输出消息内容
     * @param webSocket web
     * @param s s
     */
    @Override
    public void onMessage(WebSocket webSocket, String s) {
        for (WebSocket connection : connections) {
            connection.send(s);
        }
    }
    /**
     * 当在WebSocket连接过程中发生错误时，
     * 这个方法会被调用。
     * 在这个方法中，可以处理错误情况，比如输出错误信息
     * @param webSocket web
     * @param e error
     */
    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    /**
     * 在WebSocket服务器启动成功后，
     * 这个方法会被调用。在这个方法中，
     * 可以执行启动成功后的逻辑，
     * 比如输出启动成功的信息
     */
    @Override
    public void onStart() {
        System.out.println("服务已开启");
    }
}
