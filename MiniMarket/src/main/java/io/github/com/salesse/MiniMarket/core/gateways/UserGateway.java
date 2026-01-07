package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface UserGateway {

	User create(User user);
	User findById(UUID id);
	List<User> listAll();
	List<User> findByName(String name);
	List<User> findByEmail(String mail);
}
