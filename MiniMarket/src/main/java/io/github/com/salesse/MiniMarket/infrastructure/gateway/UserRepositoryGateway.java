package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.UserRespository;

@Component
public class UserRepositoryGateway implements UserGateway {

	private final UserRespository userRespository;

	public UserRepositoryGateway(UserRespository userRespository) {
		super();
		this.userRespository = userRespository;
	}

	@Override
	public User create(User user) {
		return UserEntityMapper.toDomain(userRespository.save(UserEntityMapper.toEntity(user)));
	}

}
