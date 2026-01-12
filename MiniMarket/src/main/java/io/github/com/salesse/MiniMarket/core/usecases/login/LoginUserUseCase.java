package io.github.com.salesse.MiniMarket.core.usecases.login;

import io.github.com.salesse.MiniMarket.core.usecases.auth.LoginResult;

public interface LoginUserUseCase {

	LoginResult execute(String email, String password);
}
