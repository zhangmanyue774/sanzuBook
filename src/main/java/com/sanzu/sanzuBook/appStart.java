//package com.sanzu.sanzuBook;
//
//import com.sanzu.sanzuBook.controller.Login.consoleFilter;
//import com.sanzu.sanzuBook.controller.bookReview.WebSocketServerTest;
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import jakarta.servlet.annotation.WebListener;
//
//import java.net.InetSocketAddress;
//@WebListener
//public class appStart implements ServletContextListener {
//    WebSocketServerTest webSocketServerTest;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        webSocketServerTest=new WebSocketServerTest(new InetSocketAddress("172.19.30.111",1314));
//        webSocketServerTest.start();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        try {
//            webSocketServerTest.stop();
//            consoleFilter.webSocketServerTest.stop();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
