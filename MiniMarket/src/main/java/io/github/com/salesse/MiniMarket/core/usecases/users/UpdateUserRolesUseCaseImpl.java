package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.RoleGateway;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class UpdateUserRolesUseCaseImpl implements UpdateUserRolesUseCase {

	private final UserGateway userGateway;
	private final RoleGateway roleGateway;

	public UpdateUserRolesUseCaseImpl(UserGateway userGateway, RoleGateway roleGateway) {
		this.userGateway = userGateway;
		this.roleGateway = roleGateway;
	}

	@Override
	public User execute(UUID userId, Set<String> roleNames) {

		User user = userGateway.findById(userId);
		user.verifyIfIsActive();

		Set<Role> roles = roleNames.stream().map(roleGateway::findByName).collect(Collectors.toSet());

		user.replaceRoles(roles);

		return userGateway.update(user, userId);
	}

}
