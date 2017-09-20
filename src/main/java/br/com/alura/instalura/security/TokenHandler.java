package br.com.alura.instalura.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public final class TokenHandler {

    private final String secret;
    private final UserDetailsService userDetailsService;

    public TokenHandler(String secret, UserDetailsService userDetailsService) {
        this.secret = secret;
        this.userDetailsService = userDetailsService;
    }

    public UserDetails parseUserFromToken(String token) {    	
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userDetailsService.loadUserByUsername(username);
    }

    public String createTokenForUser(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}