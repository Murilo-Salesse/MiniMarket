package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.UserEntity;
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

	@Override
	public User findById(UUID id) {

		UserEntity foundedUser = userRespository.findActiveById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		return UserEntityMapper.toDomain(foundedUser);
	}

	@Override
	public List<User> findByName(String name) {

		return userRespository.findUserName(name).stream().map(UserEntityMapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<User> findByEmail(String mail) {

		return userRespository.findUserEmail(mail).stream().map(UserEntityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> listAll() {

		return userRespository.findAll().stream().map(UserEntityMapper::toDomain).collect(Collectors.toList());
	}

}
