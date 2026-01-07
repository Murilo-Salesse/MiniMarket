package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.usecases.users.CreateUserUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByEmailUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.ListAllUsersUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final CreateUserUseCase createUserUseCase;
	private final FindUserByIdUseCase findUserByIdUseCase;
	private final FindUserByNameUseCase findUserByNameUseCase;
	private final FindUserByEmailUseCase findUserByEmailUseCase;
	private final ListAllUsersUseCase listAllUsersUseCase;

	public UserController(CreateUserUseCase createUserUseCase, FindUserByIdUseCase findUserByIdUseCase,
			FindUserByNameUseCase findUserByNameUseCase, FindUserByEmailUseCase findUserByEmailUseCase,
			ListAllUsersUseCase listAllUsersUseCase) {
		super();
		this.createUserUseCase = createUserUseCase;
		this.findUserByIdUseCase = findUserByIdUseCase;
		this.findUserByNameUseCase = findUserByNameUseCase;
		this.findUserByEmailUseCase = findUserByEmailUseCase;
		this.listAllUsersUseCase = listAllUsersUseCase;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserRequest request) {

		User newUser = createUserUseCase.execute(UserMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Usuário criado com sucesso.", "user",
				UserMapper.toUserResponse(newUser));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findUserById(@PathVariable UUID id) {

		User foundUser = findUserByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Usuário encontrado com sucesso.", "user",
				UserMapper.toUserResponse(foundUser));

		return ResponseEntity.ok(Map.of("data", data));
	}

	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {

		List<User> users;

		if (name != null) {
			users = findUserByNameUseCase.execute(name);
		} else if (email != null) {
			users = findUserByEmailUseCase.execute(name);
		} else {
			users = listAllUsersUseCase.execute();
		}

		return ResponseEntity.ok(Map.of("data", UserMapper.toUserResponseList(users)));
	}
}
