package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface ListAllUsersUseCase {
	
	List<User> execute();
}
