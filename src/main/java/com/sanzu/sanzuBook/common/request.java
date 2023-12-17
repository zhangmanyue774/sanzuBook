package com.sanzu.sanzuBook.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class request {
    public static String requestBody(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求体的编码为UTF-8
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        // 读取请求体内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        return requestBody.toString();
    }
    public static String getIPv4(HttpServletRequest request) throws UnknownHostException {
        String ipAddress = request.getRemoteAddr();
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        if (inetAddress instanceof Inet6Address) {
            // 处理 IPv6 地址
            String ipv4Address = inetAddress.getHostAddress();
            int indexOfColon = ipv4Address.indexOf(':');
            if (indexOfColon >= 0) {
                ipAddress = ipv4Address.substring(indexOfColon + 1);
            }
        }
        return ipAddress;
    }
}
