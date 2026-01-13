package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

public interface DeleteCategorieByIdUseCase {

	Void execute(UUID id);
}
