package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.usecases.auth.LoginResult;
import io.github.com.salesse.MiniMarket.core.usecases.login.LoginUserUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.LoginRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.LoginResponse;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.LoginMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final LoginUserUseCase loginUseCase;

	public AuthController(LoginUserUseCase loginUseCase) {
		this.loginUseCase = loginUseCase;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid LoginRequest request) {

		LoginResult result = loginUseCase.execute(request.getEmail(), request.getPassword());
		LoginResponse response = LoginMapper.toResponse(result);

		Map<String, Object> data = Map.of("message", "Usuário logado com sucesso.", "user", response);

		return ResponseEntity.ok(Map.of("data", data));
	}
}
