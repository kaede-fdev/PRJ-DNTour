package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import model.User;

import java.util.Date;

public class Jwt {

    // Secret key for signing the JWT token. In a real application, keep this secret and secure.
    private static final String SECRET_KEY = "xmkrd+MFtL5YkJSThyUxQAcKj5YHI0rUjfffXEhxg0I=";

    // Issuer of the token
    private static final String ISSUER = "DaNaTours";

    public static String generateToken(User user) {
        // Define the expiration time of the token (e.g., 1 hour)
        long expirationTime = 3600_000; // 1 hour in milliseconds
        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + expirationTime);

        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withClaim("id", user.getId())
                .withClaim("fullname", user.getFullname())
                .withClaim("email", user.getEmail())
                .withClaim("phone", user.getPhone())
                .withClaim("role", user.getRole())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public static User extractUserFromToken(String token) throws JWTDecodeException {
        DecodedJWT decodedJWT = JWT.decode(token);

        User user = new User();
        user.setId(decodedJWT.getClaim("id").asString());
        user.setFullname(decodedJWT.getClaim("fullname").asString());
        user.setEmail(decodedJWT.getClaim("email").asString());
        user.setRole(decodedJWT.getClaim("role").asString());
        user.setPhone(decodedJWT.getClaim("phone").asString());

        return user;
    }
}
