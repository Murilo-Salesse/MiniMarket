package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface FindUserByIdUseCase {

	User execute(UUID id);
}
