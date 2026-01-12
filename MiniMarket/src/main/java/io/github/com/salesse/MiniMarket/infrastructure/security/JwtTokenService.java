package io.github.com.salesse.MiniMarket.infrastructure.security;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.TokenGateway;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenService implements TokenGateway {

	private final SecretKey key;
	private final Long expiration = 1000L * 60 * 60; // 1 hora

	public JwtTokenService() {
		this.key = Keys.hmacShaKeyFor("uma-chave-com-pelo-menos-32-bytes-de-comprimento!!".getBytes());
	}

	@Override
	public String generateToken(User user) {

		Instant now = Instant.now();

		return Jwts.builder().subject(user.getId().toString())
				.claim("roles", user.getRoles().stream().map(Role::getName).toList()).claim("name", user.getName())
				.claim("email", user.getEmail()).issuedAt(Date.from(now))
				.expiration(Date.from(now.plusMillis(expiration))).signWith(key, Jwts.SIG.HS256).compact();
	}

	@Override
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getUserIdFromToken(String token) {

		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
	}

	@Override
	public List<String> getRolesFromToken(String token) {

		Object roles = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("roles");

		if (roles instanceof List<?> list) {
			return list.stream().map(String::valueOf).toList();
		}

		return List.of();
	}

	@Override
	public Optional<String> getEmailFromToken(String token) {
		return Optional.ofNullable(
				Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("email", String.class));
	}

	@Override
	public Optional<String> getNameFromToken(String token) {
		return Optional.ofNullable(
				Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("name", String.class));
	}
}
