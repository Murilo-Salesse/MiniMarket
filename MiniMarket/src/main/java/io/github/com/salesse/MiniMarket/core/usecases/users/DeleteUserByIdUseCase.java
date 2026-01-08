package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

public interface DeleteUserByIdUseCase {

	Void execute(UUID id);
}
