package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.usecases.users.CreateUserUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.DeleteUserByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByEmailUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.ListAllUsersUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.UpdateUserUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserMapper;
import jakarta.validation.Valid;

/*
 HTTP
 ↓
UserController
 ↓
UserMapper
 ↓
CreateUserUseCaseImpl
 ↓
UserGateway (interface)
 ↓
UserRepositoryGateway (implementação)
 ↓
UserEntityMapper
 ↓
UserRespository (JpaRepository)
 ↓
Banco de Dados
 * 
 * */

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final CreateUserUseCase createUserUseCase;
	private final FindUserByIdUseCase findUserByIdUseCase;
	private final FindUserByNameUseCase findUserByNameUseCase;
	private final FindUserByEmailUseCase findUserByEmailUseCase;
	private final ListAllUsersUseCase listAllUsersUseCase;
	private final UpdateUserUseCase updateUserUseCase;
	private final DeleteUserByIdUseCase deleteUserByIdUseCase;

	public UserController(CreateUserUseCase createUserUseCase, FindUserByIdUseCase findUserByIdUseCase,
			FindUserByNameUseCase findUserByNameUseCase, FindUserByEmailUseCase findUserByEmailUseCase,
			ListAllUsersUseCase listAllUsersUseCase, UpdateUserUseCase updateUserUseCase,
			DeleteUserByIdUseCase deleteUserByIdUseCase) {
		super();
		this.createUserUseCase = createUserUseCase;
		this.findUserByIdUseCase = findUserByIdUseCase;
		this.findUserByNameUseCase = findUserByNameUseCase;
		this.findUserByEmailUseCase = findUserByEmailUseCase;
		this.listAllUsersUseCase = listAllUsersUseCase;
		this.updateUserUseCase = updateUserUseCase;
		this.deleteUserByIdUseCase = deleteUserByIdUseCase;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserRequest request) {

		/*
		 * Pega o UserRequest e passa pelo UserMapper Domain para transformar em
		 * entidade PURA do banco 
		 * o Controller chama o createUserUseCase.execute passando
		 * um usuario PURO para ele, O controller não sabe o que acontece daqui para
		 * frente (depois de chamar o useCase) Ai vai la para o arquivo
		 * CreateUseCaseImpl
		 * 
		 */
		User newUser = createUserUseCase.execute(UserMapper.toDomain(request));

		/*
		 * Após tudo isso volta para ca novamente, e retorna o dominio puro e é
		 * convertido para response UserMapper.toUserResponse(newUser)
		 */
		Map<String, Object> data = Map.of("message", "Usuário criado com sucesso.", "user",
				UserMapper.toUserResponse(newUser));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> findUserById(@PathVariable UUID id) {

		User foundUser = findUserByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Usuário encontrado com sucesso.", "user",
				UserMapper.toUserResponse(foundUser));

		return ResponseEntity.ok(Map.of("data", data));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
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

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody UserUpdateRequest request,
			@PathVariable UUID id) {

		User newUser = updateUserUseCase.execute(UserMapper.toDomain(request), id);

		Map<String, Object> data = Map.of("message", "Usuário alterado com sucesso.", "store",
				UserMapper.toUserResponse(newUser));

		return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", data));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
		deleteUserByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Usuário deletado com sucesso.");

		return ResponseEntity.ok(Map.of("data", data));

	}
}
