package com.sanzu.sanzuBook.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "sanTu21";
    private static final long EXPIRATION_TIME_MS = 3600000; // 1 hour

    public static String generateToken(String account, String username,String avatar,Integer userID,boolean isAdmin) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS);

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.create()
                .withSubject(account)
                .withClaim("username", username)
                .withClaim("avatar",avatar)
                .withClaim("userID",userID)
                .withClaim("isAdmin",isAdmin)
                .withExpiresAt(expirationDate)
                .sign(algorithm);
    }

    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWT.require(algorithm).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
    public static String getAccountFromToken(String token){
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getSubject();
        }
        catch (JWTVerificationException e){
            return null;
        }
    }
    public static String getUsernameFromToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTVerificationException e) {
            return null;
        }}
    public static Integer getUserIDFromToken(String token) {
            try {
                DecodedJWT decodedJWT = JWT.decode(token);
                return decodedJWT.getClaim("userID").asInt();
            } catch (JWTVerificationException e) {
                return null;
            }
    }
        public static void main(String[] args) {
            String account = "zhangmanyue23@gmail.com";
            String username = "root";
            String avatar = "1sadsad";
            Integer userID= 2;
            boolean isAdmin = false;
            // 生成JWT
            String token = JwtUtil.generateToken(account, username,avatar,userID,isAdmin);
            System.out.println("Generated Token: " + token);

            // 验证JWT
            boolean isValid = JwtUtil.verifyToken(token);
            System.out.println("Token is valid: " + isValid);

            // 从JWT中获取用户名
            String extractedUsername = JwtUtil.getUsernameFromToken(token);
            System.out.println("Extracted Username: " + extractedUsername);
        }
}