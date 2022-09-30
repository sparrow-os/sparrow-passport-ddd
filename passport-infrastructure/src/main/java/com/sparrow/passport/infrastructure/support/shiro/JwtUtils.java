package com.sparrow.passport.infrastructure.support.shiro;

import com.sparrow.core.spi.JsonFactory;
import com.sparrow.json.Json;
import com.sparrow.protocol.LoginToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtils {
    private long expire=7*60*60;
    private String secret="123456";

    public static void main(String[] args) {
        JwtUtils jwtUtils=new JwtUtils();
        LoginToken loginToken=new LoginToken();
        loginToken.setUserId(1L);
        loginToken.setUserName("admin");
        System.out.println(jwtUtils.generateToken(loginToken));
    }

    private Json json= JsonFactory.getProvider();

    // 生成JWT
    public String generateToken(LoginToken token) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(json.toString(token))
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)    // 7天过期
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // 解析JWT
    public Claims getClaimsByToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    // 判断JWT是否过期
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
