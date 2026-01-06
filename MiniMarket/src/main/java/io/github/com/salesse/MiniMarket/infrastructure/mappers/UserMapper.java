package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.UserUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

	public static User toDomain(UserRequest request) {
		return new User(null, request.getStoreId(), request.getName(), request.getEmail(), request.getPhone(),
				request.getPassword(), true, null, null);
	}

	public static User toDomain(UserUpdateRequest request) {
		return new User(null, null, request.getName(), request.getEmail(), request.getPhone(), request.getPassword(),
				true, null, null);
	}

	public static UserResponse toUserResponse(User s) {
		return new UserResponse(s.getId(), s.getStoreId(), s.getName(), s.getEmail(), s.getPhone());
	}

	public static List<UserResponse> toUserResponseList(List<User> users) {
		return users.stream().map(UserMapper::toUserResponse).toList();
	}
}
