package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface FindUserByEmailUseCase {

	List<User> execute(String email);
}
