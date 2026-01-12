package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.core.gateways.RoleGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.RoleEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.RoleRepository;

@Component
public class RoleRepositoryGateway implements RoleGateway {

	private final RoleRepository roleRepository;

	public RoleRepositoryGateway(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name).map(RoleEntityMapper::toDomain) 
				.orElseThrow(
						() -> new IllegalStateException("Role " + name + " não encontrada. Verifique as migrations."));
	}

}
