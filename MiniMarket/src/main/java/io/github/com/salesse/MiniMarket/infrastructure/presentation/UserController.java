package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.usecases.users.CreateUserUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final CreateUserUseCase createUserUseCase;

	public UserController(CreateUserUseCase createUserUseCase) {
		super();
		this.createUserUseCase = createUserUseCase;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserRequest request) {

		User newUser = createUserUseCase.execute(UserMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Usuário criado com sucesso.", "user",
				UserMapper.toUserResponse(newUser));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

}
