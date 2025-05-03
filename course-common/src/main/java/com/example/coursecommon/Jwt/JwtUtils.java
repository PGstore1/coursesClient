package com.example.coursecommon.Jwt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JwtUtils {

    // 密钥，用于签名和验证JWT
    private static final String SECRET = "Jwt";
    // 过期时间（毫秒），例如：1小时
    private static final long EXPIRATION_TIME = 3600_000;

    /**
     * 生成JWT令牌
     * student 用studentname  作为用户ID
     * @param userId 用户ID
     * @return JWT令牌
     */
    public static String generateToken(String userId) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withClaim("userId", userId)
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("生成JWT失败", exception);
        }
    }

    /**
     * 验证JWT令牌并解析用户ID
     *
     * @param token JWT令牌
     * @return 用户ID
     */
    public static String verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("无效或过期的JWT令牌", exception);
        }
    }

    public static void main(String[] args) {
        // 示例：生成和验证JWT
        String userId = "12345";
        String token = generateToken(userId);
        System.out.println("生成的JWT: " + token);

        String verifiedUserId = verifyToken(token);
        System.out.println("验证后的用户ID: " + verifiedUserId);
    }
}

