package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {

	private final UserGateway userGateway;

	public DeleteUserByIdUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public Void execute(UUID id) {

		User user = userGateway.findById(id);
		user.deactivate();
		userGateway.update(user, id);

		return null;
	}

}
