package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

public interface DeleteStoreUseCase {

	Void execute(UUID id);
}
