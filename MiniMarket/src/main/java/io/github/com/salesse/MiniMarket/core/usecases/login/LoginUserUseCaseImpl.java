package io.github.com.salesse.MiniMarket.core.usecases.login;

import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.LoginGateway;
import io.github.com.salesse.MiniMarket.core.gateways.TokenGateway;
import io.github.com.salesse.MiniMarket.core.usecases.auth.LoginResult;

public class LoginUserUseCaseImpl implements LoginUserUseCase {

	private final LoginGateway loginGateway;
	private final PasswordEncoder passwordEncoder;
	private final TokenGateway tokenGateway;

	public LoginUserUseCaseImpl(LoginGateway loginGateway, PasswordEncoder passwordEncoder, TokenGateway tokenGateway) {
		super();
		this.loginGateway = loginGateway;
		this.passwordEncoder = passwordEncoder;
		this.tokenGateway = tokenGateway;
	}

	@Override
	public LoginResult execute(String email, String password) {

		User user = loginGateway.findByEmail(email);

		user.verifyIfIsActive();

		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new BusinessRuleException("Email ou senha inválidos");
		}

		String token = tokenGateway.generateToken(user);

		return new LoginResult(user, token);
	}
}
