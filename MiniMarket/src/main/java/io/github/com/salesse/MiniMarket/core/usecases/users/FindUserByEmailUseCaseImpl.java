package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase {

	private final UserGateway userGateway;

	public FindUserByEmailUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public List<User> execute(String email) {
		return userGateway.findByEmail(email);
	}

}
