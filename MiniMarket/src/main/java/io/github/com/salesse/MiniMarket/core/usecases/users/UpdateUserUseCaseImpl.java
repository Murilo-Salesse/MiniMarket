package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

	private final UserGateway userGateway;

	public UpdateUserUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public User execute(User user, UUID id) {
		User currentUser = userGateway.findById(id);

		if (user.getEmail() != null && !user.getEmail().equals(currentUser.getEmail())) {
			if (userGateway.existsByEmail(user.getEmail())) {
				throw new BusinessRuleException("E-mail já está em uso");
			}
			currentUser.setEmail(user.getEmail());
		}

		if (user.getPhone() != null && !user.getPhone().equals(currentUser.getPhone())) {
			if (userGateway.existsByPhone(user.getPhone())) {
				throw new BusinessRuleException("Telefone já está em uso");
			}
			currentUser.setPhone(user.getPhone());
		}

		if (user.getName() != null) {
			currentUser.setName(user.getName());
		}

		if (user.getPassword() != null) {
			currentUser.setPassword(user.getPassword());
		}

		return userGateway.update(currentUser, id);
	}
}
