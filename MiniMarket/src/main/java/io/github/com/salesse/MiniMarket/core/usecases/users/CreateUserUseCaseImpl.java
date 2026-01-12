package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.RoleGateway;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

	private final UserGateway userGateway;
	private final PasswordEncoder passwordEncoder;
	private final RoleGateway roleGateway;

	public CreateUserUseCaseImpl(UserGateway userGateway, PasswordEncoder passwordEncoder, RoleGateway roleGateway) {
		super();
		this.userGateway = userGateway;
		this.passwordEncoder = passwordEncoder;
		this.roleGateway = roleGateway;
	}

	@Override
	public User execute(User user) {

		if (userGateway.existsByEmail(user.getEmail())) {
			throw new BusinessRuleException("Email já cadastrado");
		}

		if (userGateway.existsByPhone(user.getPhone())) {
			throw new BusinessRuleException("Telefone já cadastrado");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role clientRole = roleGateway.findByName("CLIENTE");
		user.replaceRoles(Set.of(clientRole));

		/*
		 * Aqui após validar a request pura, ele chama o gateway O Use Case não sabe
		 * quem salva, só sabe que alguém salva Foi la para o arquivo
		 * UserRepositoryGateway
		 */
		return userGateway.create(user);
	}

}
