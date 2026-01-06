package io.github.com.salesse.MiniMarket.core.usecases.users;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface CreateUserUseCase {

	User execute(User user);
}
