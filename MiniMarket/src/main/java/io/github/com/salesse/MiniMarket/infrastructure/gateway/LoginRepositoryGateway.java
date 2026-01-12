package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.LoginGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.UserEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.UserEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.UserRespository;

@Component
public class LoginRepositoryGateway implements LoginGateway {

    private final UserRespository userRepository;

    public LoginRepositoryGateway(UserRespository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email)
            .orElseThrow(() -> new BusinessRuleException("Email ou senha inválidos"));

        return UserEntityMapper.toDomain(entity);
    }
}
