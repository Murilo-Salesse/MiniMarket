package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.Set;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface UpdateUserRolesUseCase {

	User execute(UUID userId, Set<String> roleNames);

}