package com.vast.common.component;

import com.vast.common.config.properties.TokenProperties;
import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

@Component
public class JWTOperator {

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    @Autowired
    private TokenProperties tokenProperties;

    public String generateJWT(Map<String, Object> claims) {
        return generate(claims,tokenProperties.getExpirationTime());
    }

    public String generateRefreshJWT(Map<String, Object> claims) {
        return generate(claims,tokenProperties.getRefreshExpTime());
    }

    public Claims verifyJWT(String token) {
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }

    public Claims getClaims(String token){
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }catch (Exception ex){
            return null;
        }
    }

    private String generate(Map<String, Object> claims,long expTime){

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + expTime);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setIssuer(tokenProperties.getIssuer())
                .signWith(SIGNATURE_ALGORITHM, secretKey)
                .setExpiration(exp);
        return builder.compact();
    }

    private SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(tokenProperties.getSigningKey());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
