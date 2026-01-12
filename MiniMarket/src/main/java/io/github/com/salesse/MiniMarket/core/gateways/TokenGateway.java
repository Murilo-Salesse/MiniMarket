package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.Optional;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface TokenGateway {

	String generateToken(User user);
	String getUserIdFromToken(String token);
	List<String> getRolesFromToken(String token);
	Optional<String> getEmailFromToken(String token);
	Optional<String> getNameFromToken(String token);
	boolean isTokenValid(String token);
}
