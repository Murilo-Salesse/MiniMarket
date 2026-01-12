package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.stream.Collectors;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.core.usecases.auth.LoginResult;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.LoginResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginMapper {

	public static LoginResponse toResponse(LoginResult result) {
		return new LoginResponse(result.getUser().getId(), result.getUser().getName(), result.getUser().getEmail(),
				result.getToken(), result.getUser().getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
	}
}