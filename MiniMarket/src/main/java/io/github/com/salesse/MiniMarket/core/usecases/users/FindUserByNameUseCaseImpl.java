package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class FindUserByNameUseCaseImpl implements FindUserByNameUseCase {

	private final UserGateway userGateway;

	public FindUserByNameUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public List<User> execute(String name) {
		return userGateway.findByName(name);
	}

}
