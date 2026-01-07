package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class ListAllUsersUseCaseImpl implements ListAllUsersUseCase {

	private UserGateway userGateway;

	public ListAllUsersUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public List<User> execute() {

		return userGateway.listAll();
	}

}
