package io.github.com.salesse.MiniMarket.core.usecases.users;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

	private final UserGateway userGateway;

	public CreateUserUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public User execute(User user) {

		if (userGateway.existsByEmail(user.getEmail())) {
			throw new BusinessRuleException("Email já cadastrado");
		}

		if (userGateway.existsByPhone(user.getPhone())) {
			throw new BusinessRuleException("Telefone já cadastrado");
		}

		/* Aqui após validar a request pura, ele chama o gateway
		 * O Use Case não sabe quem salva, só sabe que alguém salva
		 * Foi la para o arquivo UserRepositoryGateway
		 *  */
		return userGateway.create(user);
	}

}
