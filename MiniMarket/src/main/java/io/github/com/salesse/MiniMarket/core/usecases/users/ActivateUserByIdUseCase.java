package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

public interface ActivateUserByIdUseCase {

	Void execute(UUID id);
}
